package rubenpla.develop.privtmdbendlesslist.ui.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import rubenpla.develop.privtmdbendlesslist.R
import rubenpla.develop.privtmdbendlesslist.bind.model.MovieBindModel
import rubenpla.develop.privtmdbendlesslist.databinding.MovieItemListBinding
import rubenpla.develop.privtmdbendlesslist.databinding.MovieItemProgressBinding
import rubenpla.develop.privtmdbendlesslist.ui.adapter.base.BaseMoviesAdapter

/**
 * Created by alten on 13/2/18.
 */
class PopularMoviesAdapter (private val context : Context?,
                            private val list : MutableList<MovieBindModel?>,
                            private val listener : (MovieBindModel?) -> Unit)
    : BaseMoviesAdapter(context, list) {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == -1)
                    ProgressbarViewHolder(LayoutInflater.from(context)
                            .inflate(R.layout.movie_item_progress, parent, false))
               else
                    MovieViewHolder(LayoutInflater.from(context).inflate(R.layout.movie_item_list,
                            parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        if (holder is MovieViewHolder)
            holder.bind(list[position], listener)
        else (holder as? ProgressbarViewHolder)?.bind(true)
    }

    fun add(movie: MovieBindModel?) {
        list.add(movie)
        notifyItemInserted(list.size -1)
    }

    fun addAll(movies: List<MovieBindModel>) {
        list.addAll(movies)
        notifyItemRangeChanged( movies.size,list.size -1)
    }

    fun remove(position: Int) {
        list.removeAt(position)
        notifyItemRemoved(list.size)
    }

    fun clear() {
        list.clear()
        notifyDataSetChanged()
    }

    /**
     *    HOLDERS
     **/
    internal  class MovieViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        private val binding : MovieItemListBinding = DataBindingUtil.bind(itemView)

        fun bind(movie : MovieBindModel?, listener : (MovieBindModel?) -> Unit) {
            Picasso.with(itemView.context)
                    .load(movie?.imageUrl)
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher_round)
                    .fit()
                    .priority(Picasso.Priority.HIGH)
                    .into(itemView.findViewById(R.id.movie_item_list_card_view_image_view),
                            null)

            binding.movieBindModel = movie
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