package rubenpla.develop.privtmdbendlesslist.ui.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import rubenpla.develop.privtmdbendlesslist.bind.model.MovieBindModel
import rubenpla.develop.privtmdbendlesslist.databinding.MovieItemListBinding
import rubenpla.develop.privtmdbendlesslist.databinding.MovieItemProgressBinding
import rubenpla.develop.privtmdbendlesslist.ui.adapter.base.BaseMoviesAdapter

/**
 * Created by alten on 13/2/18.
 */
class PopularMoviesAdapter (val context : Context, val list : MutableList<MovieBindModel?>)
    : BaseMoviesAdapter(context, list) {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return super.onCreateViewHolder(parent, viewType)
    }

    override fun getItemCount(): Int {
        return super.getItemCount()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        super.onBindViewHolder(holder, position)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int, payloads: MutableList<Any>?) {
        super.onBindViewHolder(holder, position, payloads)
    }

    internal  class MovieViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        private val binding : MovieItemListBinding = DataBindingUtil.bind(itemView)

        fun bind(movie : MovieBindModel, listener : (MovieBindModel?) -> Unit) {
            binding.movie = movie
            itemView.setOnClickListener { listener(movie) }
        }
    }

    internal class ProgressbarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding : MovieItemProgressBinding = DataBindingUtil.bind(itemView)

        fun bind (isIndeterminate : Boolean) {
            binding.movieItemProgressProgressbar.isIndeterminate = isIndeterminate
        }

    }
}