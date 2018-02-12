package rubenpla.develop.privtmdbendlesslist.bind.adapter

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView

/**
 * Created by alten on 9/2/18.
 */
class BindingAdapter {
    @BindingAdapter(value = *arrayOf("visibleThreshold", "resetLoading"), requireAll = false)
    fun setRecyclerViewScrollCallback(recyclerView: RecyclerView, visibleThreshold: Int,
                                      resetLoading: Boolean) {


    }
}