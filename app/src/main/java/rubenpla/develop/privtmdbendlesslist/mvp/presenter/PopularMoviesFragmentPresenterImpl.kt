package rubenpla.develop.privtmdbendlesslist.mvp.presenter

import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.processors.PublishProcessor
import rubenpla.develop.privtmdbendlesslist.BuildConfig
import rubenpla.develop.privtmdbendlesslist.data.api.TmdbApi
import rubenpla.develop.privtmdbendlesslist.data.model.MoviesResponse
import rubenpla.develop.privtmdbendlesslist.data.repository.PopularMoviesRepository
import rubenpla.develop.privtmdbendlesslist.mvp.PopularMoviesFragmentMvpContract.PopularMoviesFragmentPresenter
import rubenpla.develop.privtmdbendlesslist.mvp.PopularMoviesFragmentMvpContract.PopularMoviesFragmentView

/**
 * Created by alten on 14/2/18.
 */
class PopularMoviesFragmentPresenterImpl(private val view : PopularMoviesFragmentView) :
    PopularMoviesFragmentPresenter {

    private var currentPage: Int = 0
    private val disposables : CompositeDisposable = CompositeDisposable()
    private lateinit var paginator: PublishProcessor<Int>
    private var loading : Boolean = false

    init {
        initialize()
    }

    override fun initialize() {
        currentPage = 1
        paginator = PublishProcessor.create()

        val disposable = paginator.onBackpressureDrop()
                .filter { !loading }
                .doOnNext { loading = view.showProgress()}
                .concatMap { getPopularMovies(it) }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    loading = view.hideProgress()
                    view.showItems(it.results)
                    currentPage++
                }, {
                    loading = view.hideProgress()
                    view.showMessage(it.localizedMessage)
                } )

        disposables.add(disposable)
        onLoadMore(currentPage)
    }

    override fun terminate() {
        disposables.clear()
    }

    override fun getPopularMovies(page: Int): Flowable<MoviesResponse>? {
        val popularMoviesRepository  = PopularMoviesRepository(TmdbApi.Factory.getInstance())

        return Flowable.just(page)
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap { _ -> popularMoviesRepository
                        .getPopularMoviesFromApi(BuildConfig.THE_MOVIE_DB_API_TOKEN, page)
                }
    }

    override fun onLoadMore(page: Int) {
        paginator.onNext(page)
    }
}