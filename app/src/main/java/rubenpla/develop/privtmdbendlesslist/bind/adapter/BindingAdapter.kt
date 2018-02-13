package rubenpla.develop.privtmdbendlesslist.bind.adapter

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import rubenpla.develop.privtmdbendlesslist.ui.adapter.callback.RecyclerViewScrollCallback

/**
 * Created by alten on 9/2/18.
 */
class BindingAdapter {
    @BindingAdapter(value = ["visibleThreshold", "resetLoading", "onScrolledToBottom"], requireAll = true)
    fun setRecyclerViewScrollCallback(recyclerView: RecyclerView, visibleThreshold: Int,
                                      resetLoading: Boolean,
                                      onScrolledListener : RecyclerViewScrollCallback.OnScrolledListener) {

        val callback = RecyclerViewScrollCallback.Builder(recyclerView.layoutManager)
                .onScrolledListener(onScrolledListener)
                .visibleThreshold(visibleThreshold)
                .resetLoadingState(resetLoading)
                .build()

        recyclerView.clearOnScrollListeners()
        recyclerView.addOnScrollListener(callback)
    }
}