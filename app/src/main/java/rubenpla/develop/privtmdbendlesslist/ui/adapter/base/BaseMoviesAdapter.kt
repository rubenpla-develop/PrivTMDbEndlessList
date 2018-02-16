package rubenpla.develop.privtmdbendlesslist.ui.adapter.base

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import rubenpla.develop.privtmdbendlesslist.bind.model.MovieBindModel

/**
 * Created by alten on 13/2/18.
 */
open class BaseMoviesAdapter(private val context:
                             Context?, private val list: MutableList<MovieBindModel?>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}