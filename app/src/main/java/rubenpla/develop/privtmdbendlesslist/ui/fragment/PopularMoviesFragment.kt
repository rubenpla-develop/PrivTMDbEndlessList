package rubenpla.develop.privtmdbendlesslist.ui.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.annotation.NonNull
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import rubenpla.develop.privtmdbendlesslist.R
import rubenpla.develop.privtmdbendlesslist.bind.BindingComponent
import rubenpla.develop.privtmdbendlesslist.bind.model.MovieBindModel
import rubenpla.develop.privtmdbendlesslist.bind.model.PopularMoviesFragmentBindModel
import rubenpla.develop.privtmdbendlesslist.data.model.MoviesResultsItem
import rubenpla.develop.privtmdbendlesslist.databinding.PopularMoviesFragmentBinding
import rubenpla.develop.privtmdbendlesslist.mvp.PopularMoviesFragmentMvpContract.PopularMoviesFragmentPresenter
import rubenpla.develop.privtmdbendlesslist.mvp.PopularMoviesFragmentMvpContract.PopularMoviesFragmentView
import rubenpla.develop.privtmdbendlesslist.mvp.presenter.PopularMoviesFragmentPresenterImpl
import rubenpla.develop.privtmdbendlesslist.ui.adapter.PopularMoviesAdapter
import rubenpla.develop.privtmdbendlesslist.util.Mapper

class PopularMoviesFragment : Fragment(), PopularMoviesFragmentView {

    private lateinit var presenter : PopularMoviesFragmentPresenter
    private lateinit var popularMoviesFragmentModel: PopularMoviesFragmentBindModel
    private lateinit var popularMoviesAdapter : PopularMoviesAdapter
    private var list = arrayListOf<MovieBindModel?>()
    private lateinit var binding : PopularMoviesFragmentBinding

    companion object {

        fun newInstance(): PopularMoviesFragment {
            return PopularMoviesFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,
                R.layout.popular_movies_fragment, container, false,
                BindingComponent())

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setBindings()

        popularMoviesAdapter = PopularMoviesAdapter(context, list) {}
        presenter = PopularMoviesFragmentPresenterImpl(this)
        binding.popularMoviesRecyclerview.itemAnimator = DefaultItemAnimator()
        binding.popularMoviesRecyclerview.adapter =popularMoviesAdapter
        binding.presenter = presenter
    }

    override fun onDestroyView() {
        super.onDestroyView()

        presenter.terminate()
    }

    private fun setBindings() {
        popularMoviesFragmentModel = PopularMoviesFragmentBindModel()
        popularMoviesFragmentModel.visibleThreshold = 10
        binding.popularMoviesModel = popularMoviesFragmentModel
    }

    override fun setPresenter(@NonNull presenter: PopularMoviesFragmentPresenter) {
        this.presenter = checkNotNull(presenter)
    }

    override fun showMessage(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }

    override fun showItems(items: List<MoviesResultsItem?>?) {
        val mappedItems = arrayListOf<MovieBindModel>()
        items?.map { mappedItems.add(Mapper.mapToMovieBindModelFromApi(it))}
        popularMoviesAdapter.addAll(mappedItems)
    }

    override fun showProgress(): Boolean {
        popularMoviesAdapter.addLoadingView()

        return true
    }

    override fun hideProgress(): Boolean {
        if (list.size > 0 && null == list[list.size - 1]) {
           // popularMoviesAdapter.remove(list.size -1)
            popularMoviesAdapter.removeLoadingView()
        }

        return false
    }
}