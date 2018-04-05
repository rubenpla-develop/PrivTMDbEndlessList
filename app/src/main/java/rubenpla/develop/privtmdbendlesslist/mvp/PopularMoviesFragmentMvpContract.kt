package rubenpla.develop.privtmdbendlesslist.mvp

import io.reactivex.Flowable
import rubenpla.develop.privtmdbendlesslist.data.model.MoviesResponse
import rubenpla.develop.privtmdbendlesslist.data.model.MoviesResultsItem
import rubenpla.develop.privtmdbendlesslist.mvp.base.BasePresenter
import rubenpla.develop.privtmdbendlesslist.mvp.base.BaseView

interface PopularMoviesFragmentMvpContract {

    interface PopularMoviesFragmentView : BaseView<PopularMoviesFragmentPresenter> {
        fun showItems(items: List<MoviesResultsItem?>?)
        fun showProgress(): Boolean
        fun hideProgress(): Boolean
    }

    interface PopularMoviesFragmentPresenter : BasePresenter {
        fun getPopularMovies(page: Int): Flowable<MoviesResponse>?
        fun onLoadMore(page : Int)
    }
}