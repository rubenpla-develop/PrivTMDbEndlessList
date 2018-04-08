package rubenpla.develop.privtmdbendlesslist.ui.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.annotation.NonNull
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import rubenpla.develop.privtmdbendlesslist.R
import rubenpla.develop.privtmdbendlesslist.bind.BindingComponent
import rubenpla.develop.privtmdbendlesslist.bind.model.SearchMoviesFragmentBindModel
import rubenpla.develop.privtmdbendlesslist.data.model.MoviesResultsItem
import rubenpla.develop.privtmdbendlesslist.databinding.SearchMovieFragmentBinding
import rubenpla.develop.privtmdbendlesslist.mvp.SearchMoviesFragmentMvpContract.SearchMoviesFragmentPresenter
import rubenpla.develop.privtmdbendlesslist.mvp.SearchMoviesFragmentMvpContract.SearchMoviesFragmentView
import rubenpla.develop.privtmdbendlesslist.mvp.presenter.SearchMoviesFragmentPresenterImpl

class SearchMovieFragment : Fragment(), SearchMoviesFragmentView {

    private lateinit var presenter: SearchMoviesFragmentPresenter
    private lateinit var searchMoviesFragmentModel: SearchMoviesFragmentBindModel
    private lateinit var binding : SearchMovieFragmentBinding

    companion object {

        fun newInstance(): PopularMoviesFragment {
            return PopularMoviesFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,
                R.layout.search_movie_fragment, container, false,
                BindingComponent())

        return binding.root    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setBindings()
        presenter = SearchMoviesFragmentPresenterImpl(this)
        binding.presenter = presenter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    private fun setBindings() {
        searchMoviesFragmentModel = SearchMoviesFragmentBindModel()
        searchMoviesFragmentModel.visibleThreshold = 10
        binding.searchMoviesModel = searchMoviesFragmentModel
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