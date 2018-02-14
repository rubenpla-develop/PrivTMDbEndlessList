package rubenpla.develop.privtmdbendlesslist.mvp.presenter

import android.graphics.Movie
import rubenpla.develop.privtmdbendlesslist.mvp.PopularMoviesFragmentMvpContract.PopularMoviesFragmentPresenter
import rubenpla.develop.privtmdbendlesslist.mvp.PopularMoviesFragmentMvpContract.PopularMoviesFragmentView

/**
 * Created by alten on 14/2/18.
 */
class PopularMoviesFragmentPresenterImpl(private val view : PopularMoviesFragmentView) :
    PopularMoviesFragmentPresenter{

    override fun initialize() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun terminate() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPopularMovies(page: Int): List<Movie> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onLoadMore(page: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}