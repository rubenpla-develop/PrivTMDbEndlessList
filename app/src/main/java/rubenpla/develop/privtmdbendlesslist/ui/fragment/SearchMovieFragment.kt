package rubenpla.develop.privtmdbendlesslist.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import rubenpla.develop.privtmdbendlesslist.R

/**
 * Created by alten on 4/2/18.
 */
class SearchMovieFragment : Fragment() {

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
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}