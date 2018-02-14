package rubenpla.develop.privtmdbendlesslist.ui.fragment

import android.databinding.DataBindingUtil
import android.graphics.Movie
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import rubenpla.develop.privtmdbendlesslist.R
import rubenpla.develop.privtmdbendlesslist.bind.BindingComponent
import rubenpla.develop.privtmdbendlesslist.databinding.PopularMoviesFragmentBinding
import rubenpla.develop.privtmdbendlesslist.mvp.PopularMoviesFragmentMvpContract.PopularMoviesFragmentPresenter
import rubenpla.develop.privtmdbendlesslist.mvp.PopularMoviesFragmentMvpContract.PopularMoviesFragmentView

/**
 * Created by alten on 4/2/18.
 */
class PopularMoviesFragment : Fragment(), PopularMoviesFragmentView {

    private lateinit var presenter : PopularMoviesFragmentPresenter

    companion object {

        fun newInstance(): PopularMoviesFragment {
            return PopularMoviesFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var binding : PopularMoviesFragmentBinding = DataBindingUtil.inflate(inflater,
                R.layout.popular_movies_fragment, container, false,
                BindingComponent())

        return binding.root
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun setPresenter(presenter: PopularMoviesFragmentPresenter) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showMessage(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showItems(items: List<Movie>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showProgress(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideProgress(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}