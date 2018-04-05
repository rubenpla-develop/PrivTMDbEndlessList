package rubenpla.develop.privtmdbendlesslist.mvp.presenter

import io.reactivex.Flowable
import rubenpla.develop.privtmdbendlesslist.data.model.MoviesResponse
import rubenpla.develop.privtmdbendlesslist.mvp.SearchMoviesFragmentMvpContract
import rubenpla.develop.privtmdbendlesslist.mvp.SearchMoviesFragmentMvpContract.SearchMoviesFragmentView

class SearchMoviesFragmentPresenterImpl(private val view : SearchMoviesFragmentView)
    : SearchMoviesFragmentMvpContract.SearchMoviesFragmentPresenter{

    init {
        initialize()
    }

    override fun initialize() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun terminate() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getSearchResults(page: Int): Flowable<MoviesResponse>? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onLoadMore(page: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}