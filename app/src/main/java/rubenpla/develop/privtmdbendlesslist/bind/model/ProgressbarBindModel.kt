package rubenpla.develop.privtmdbendlesslist.bind.model

import android.databinding.BaseObservable
import android.databinding.Bindable
import rubenpla.develop.privtmdbendlesslist.BR

class ProgressbarBindModel : BaseObservable() {

    @get:Bindable
    var isIndeterminate : Boolean = false
    set(isIndeterminate) {
        field = isIndeterminate
        notifyPropertyChanged(BR.indeterminate)
    }
}