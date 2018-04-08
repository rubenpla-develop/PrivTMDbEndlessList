package rubenpla.develop.privtmdbendlesslist.mvp

import io.reactivex.Flowable
import rubenpla.develop.privtmdbendlesslist.data.model.MoviesResponse
import rubenpla.develop.privtmdbendlesslist.data.model.MoviesResultsItem
import rubenpla.develop.privtmdbendlesslist.mvp.base.BasePresenter
import rubenpla.develop.privtmdbendlesslist.mvp.base.BaseView

interface SearchMoviesFragmentMvpContract {

    interface SearchMoviesFragmentView : BaseView<SearchMoviesFragmentPresenter> {
        fun showItems(items: List<MoviesResultsItem?>?)
        fun showSelectedMovie(item : MoviesResultsItem?)
        fun showProgress(): Boolean
        fun hideProgress(): Boolean
    }

    interface SearchMoviesFragmentPresenter : BasePresenter {
        fun getSearchResults(textToSearch : String , page: Int)
        fun onLoadMore(page : Int)
    }
}