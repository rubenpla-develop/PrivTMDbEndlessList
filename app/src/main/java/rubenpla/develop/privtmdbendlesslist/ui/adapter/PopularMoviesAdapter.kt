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

 open class PopularMoviesAdapter (private val context : Context?,
                            private val list : MutableList<MovieBindModel?>,
                            private val listener : (MovieBindModel?) -> Unit)
    : BaseMoviesAdapter(context, list) {

    private var isLoadingMoreItems: Boolean = false

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val viewToReturn : Int = viewType
        val holder : RecyclerView.ViewHolder

        holder = when (viewToReturn) {
            ITEM -> {
                MovieViewHolder(LayoutInflater.from(context).inflate(R.layout.movie_item_list,
                    parent, false))
            }
            LOADING -> {
                ProgressbarViewHolder(LayoutInflater.from(context)
                    .inflate(R.layout.movie_item_progress, parent, false))
            }
            else -> {
                MovieViewHolder(LayoutInflater.from(context).inflate(R.layout.movie_item_list,
                        parent, false))
            }
        }

        return holder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        when (holder) {
            is MovieViewHolder -> holder.bind(
                    list[position],
                    listener
            )
            is ProgressbarViewHolder -> holder.bind(true)
        }
    }



    override fun getItemViewType(position: Int): Int {
        val listSize : Int = list.size - 1

        return if (listSize == position && isLoadingMoreItems)
            LOADING
        else
            ITEM
    }

    fun getItem(position: Int): MovieBindModel? {
        return list[position]
    }


    /**
     *    HELPERS
     **/

    fun addLoadingView() {
        isLoadingMoreItems = true

        add(null)
    }

    fun removeLoadingView() {
        isLoadingMoreItems  = false

        val position = list.size - 1
        val result = getItem(position)

        if (result == null) {
            list.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    fun add(movie: MovieBindModel?) {
        list.add(movie)
        notifyItemInserted(list.size -1)
    }

    fun addAll(movies: ArrayList<MovieBindModel>) {
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
        private val binding : MovieItemListBinding? = DataBindingUtil.bind(itemView)

        fun bind(movie : MovieBindModel?, listener : (MovieBindModel?) -> Unit) {

            when (itemViewType) {
                //TODO 'ITEM' item
                 ITEM -> {
                    Picasso.with(itemView.context)
                            .load(movie?.imageUrl)
                            .error(R.mipmap.ic_launcher)
                            .fit()
                            .priority(Picasso.Priority.HIGH)
                            .into(itemView.findViewById(R.id.movie_item_list_card_view_image_view),
                                    null)

                    binding!!.movieBindModel = movie
                    itemView.setOnClickListener { listener(movie) }
                }
                //TODO 'LOADING' item
                LOADING -> {  /* DO NOTHING */ }
            }
        }
    }

    internal class ProgressbarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding : MovieItemProgressBinding? = DataBindingUtil.bind(itemView)

        fun bind (isIndeterminate : Boolean) {
            binding?.movieItemProgressProgressbar!!.isIndeterminate = isIndeterminate
        }
    }

    companion object {
        const val LOADING: Int = 1
        const val ITEM : Int = 0
    }
}