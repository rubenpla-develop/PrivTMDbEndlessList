package rubenpla.develop.privtmdbendlesslist.mvp

import android.graphics.Movie
import rubenpla.develop.privtmdbendlesslist.mvp.base.BasePresenter
import rubenpla.develop.privtmdbendlesslist.mvp.base.BaseView

/**
 * Created by alten on 13/2/18.
 */
interface PopularMoviesFragmentMvpContract {

    interface PopularMoviesFragmentView : BaseView<PopularMoviesFragmentPresenter> {
        fun showItems(items : List<Movie>)
        fun showError(message : String)
        fun showProgress(): Boolean
        fun hideProgress(): Boolean
    }

    interface PopularMoviesFragmentPresenter : BasePresenter {
        fun getPopularMovies(page : Int) : List<Movie>
        fun onLoadMore(page : Int)
    }
}