package rubenpla.develop.privtmdbendlesslist.mvp.presenter

import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.processors.PublishProcessor
import io.reactivex.schedulers.Schedulers
import rubenpla.develop.privtmdbendlesslist.BuildConfig
import rubenpla.develop.privtmdbendlesslist.data.api.TmdbApi
import rubenpla.develop.privtmdbendlesslist.data.model.MoviesResponse
import rubenpla.develop.privtmdbendlesslist.data.repository.PopularMoviesRepository
import rubenpla.develop.privtmdbendlesslist.data.repository.SearchMoviesRepository
import rubenpla.develop.privtmdbendlesslist.mvp.SearchMoviesFragmentMvpContract
import rubenpla.develop.privtmdbendlesslist.mvp.SearchMoviesFragmentMvpContract.SearchMoviesFragmentView
import java.util.concurrent.TimeUnit

class SearchMoviesFragmentPresenterImpl(private val view : SearchMoviesFragmentView)
    : SearchMoviesFragmentMvpContract.SearchMoviesFragmentPresenter {

    private var currentPage: Int = 0
    private var currentTextQuery : String = ""
    private var loading : Boolean = false
    private val disposables : CompositeDisposable = CompositeDisposable()
    private lateinit var paginator : PublishProcessor<Int>

    init {
        initialize()
    }

    override fun initialize() {
        currentPage = 1
        paginator = PublishProcessor.create()

        val disposable = paginator.onBackpressureDrop()
                .debounce(1000, TimeUnit.MILLISECONDS)
                .filter{ currentTextQuery != "" }
                .distinctUntilChanged()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .switchMap{ getMovieResults(currentPage)
                        ?.subscribeOn(Schedulers.io())
                        ?.observeOn(AndroidSchedulers.mainThread()) }
                .subscribe({
                    loading = view.hideProgress()
                    view.showItems(it.results)
                    currentPage++
                }, {
                    loading = view.hideProgress()
                    view.showMessage(it.localizedMessage)
                } )

        disposables.add(disposable)
    }

    override fun terminate() {
        disposables.clear()
    }

    override fun getSearchResults(textToSearch : String, page: Int) {
        currentPage = 1
        currentTextQuery = textToSearch
        paginator.onNext(page)
    }

    private fun getMovieResults(page : Int) : Flowable<MoviesResponse>? {
        val searchMoviesRepository  = SearchMoviesRepository(TmdbApi.getInstance())

        return Flowable.just(page)
                .flatMap { _ -> searchMoviesRepository
                        .searchMoviesFromApi(BuildConfig.THE_MOVIE_DB_API_TOKEN, currentTextQuery,
                                page)
                }
    }

    override fun onLoadMore(page: Int) {
        paginator.onNext(page)
    }
}