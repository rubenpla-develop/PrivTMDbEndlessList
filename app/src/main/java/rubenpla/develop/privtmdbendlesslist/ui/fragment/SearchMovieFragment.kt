package rubenpla.develop.privtmdbendlesslist.ui.fragment

import android.os.Bundle
import android.support.annotation.NonNull
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import rubenpla.develop.privtmdbendlesslist.R
import rubenpla.develop.privtmdbendlesslist.data.model.MoviesResultsItem
import rubenpla.develop.privtmdbendlesslist.mvp.SearchMoviesFragmentMvpContract.SearchMoviesFragmentPresenter
import rubenpla.develop.privtmdbendlesslist.mvp.SearchMoviesFragmentMvpContract.SearchMoviesFragmentView
import rubenpla.develop.privtmdbendlesslist.mvp.presenter.SearchMoviesFragmentPresenterImpl

class SearchMovieFragment : Fragment(), SearchMoviesFragmentView {

    private lateinit var presenter: SearchMoviesFragmentPresenter

    companion object {

        fun newInstance(): PopularMoviesFragment {
            return PopularMoviesFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.search_movie_fragment, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = SearchMoviesFragmentPresenterImpl(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun showSelectedMovie(item: MoviesResultsItem?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showProgress(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideProgress(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setPresenter(@NonNull presenter: SearchMoviesFragmentPresenter) {
        this.presenter = checkNotNull(presenter)
    }

    override fun showMessage(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }
}