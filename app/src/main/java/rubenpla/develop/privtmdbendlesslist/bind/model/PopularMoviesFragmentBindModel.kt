package rubenpla.develop.privtmdbendlesslist.bind.model

import android.databinding.BaseObservable
import android.databinding.Bindable
import rubenpla.develop.privtmdbendlesslist.BR

class PopularMoviesFragmentBindModel : BaseObservable() {

    @get:Bindable
    var resetLoading: Boolean = false
        set(resetLoading) {
            field = resetLoading
            notifyPropertyChanged(BR.resetLoading)
        }
    @get:Bindable
    var visibleThreshold: Int = 0
        set(visibleThreshold) {
            field = visibleThreshold
            notifyPropertyChanged(BR.visibleThreshold)
        }
}