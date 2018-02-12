package rubenpla.develop.privtmdbendlesslist.bind

import rubenpla.develop.privtmdbendlesslist.bind.adapter.BindingAdapter

class BindingComponent : android.databinding.DataBindingComponent {
    override fun getBindingAdapter() = BindingAdapter()
}