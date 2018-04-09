package rubenpla.develop.privtmdbendlesslist.ui.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.annotation.NonNull
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.SearchView.OnQueryTextListener
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.search_movie_fragment.*
import rubenpla.develop.privtmdbendlesslist.R
import rubenpla.develop.privtmdbendlesslist.bind.BindingComponent
import rubenpla.develop.privtmdbendlesslist.bind.model.MovieBindModel
import rubenpla.develop.privtmdbendlesslist.bind.model.SearchMoviesFragmentBindModel
import rubenpla.develop.privtmdbendlesslist.data.model.MoviesResultsItem
import rubenpla.develop.privtmdbendlesslist.databinding.SearchMovieFragmentBinding
import rubenpla.develop.privtmdbendlesslist.mvp.SearchMoviesFragmentMvpContract.SearchMoviesFragmentPresenter
import rubenpla.develop.privtmdbendlesslist.mvp.SearchMoviesFragmentMvpContract.SearchMoviesFragmentView
import rubenpla.develop.privtmdbendlesslist.mvp.presenter.SearchMoviesFragmentPresenterImpl
import rubenpla.develop.privtmdbendlesslist.ui.adapter.MoviesAdapter
import rubenpla.develop.privtmdbendlesslist.util.Mapper

class SearchMovieFragment : Fragment(), SearchMoviesFragmentView {

    private lateinit var presenter: SearchMoviesFragmentPresenter
    private lateinit var searchMoviesFragmentModel: SearchMoviesFragmentBindModel
    private lateinit var binding : SearchMovieFragmentBinding
    private var list = arrayListOf<MovieBindModel?>()
    private lateinit var moviesAdapter : MoviesAdapter

    private val onQueryTextListener : OnQueryTextListener = object : OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?): Boolean {
            return false
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            moviesAdapter.clear()
            binding.searchMoviesRecyclerview.adapter = moviesAdapter
            presenter.getSearchResults(newText!!, 2)

            return false
        }
    }

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

        moviesAdapter = MoviesAdapter(context, list) {}
        presenter = SearchMoviesFragmentPresenterImpl(this)
        binding.searchMoviesRecyclerview.itemAnimator = DefaultItemAnimator()
        binding.searchMoviesRecyclerview.adapter = moviesAdapter
        search_movie_textview.setOnQueryTextListener(onQueryTextListener)
        binding.presenter = presenter
    }

    override fun onDestroyView() {
        super.onDestroyView()

        presenter.terminate()
    }

    private fun setBindings() {
        searchMoviesFragmentModel = SearchMoviesFragmentBindModel()
        searchMoviesFragmentModel.visibleThreshold = 10
        binding.searchMoviesModel = searchMoviesFragmentModel
    }

    override fun showItems(items: List<MoviesResultsItem?>?) {
        val mappedItems = arrayListOf<MovieBindModel>()
        items?.map { mappedItems.add(Mapper.mapToMovieBindModelFromApi(it))}
        moviesAdapter.addAll(mappedItems)
    }

    override fun showSelectedMovie(item: MoviesResultsItem?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showProgress(): Boolean {
        moviesAdapter.addLoadingView()

        return true
    }

    override fun hideProgress(): Boolean {
        if (list.size > 0 && null == list[list.size - 1]) {
            moviesAdapter.removeLoadingView()
        }

        return false    }

    override fun setPresenter(@NonNull presenter: SearchMoviesFragmentPresenter) {
        this.presenter = checkNotNull(presenter)
    }

    override fun showMessage(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }
}