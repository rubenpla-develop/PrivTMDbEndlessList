package rubenpla.develop.privtmdbendlesslist.bind.model

import android.databinding.BaseObservable
import android.databinding.Bindable
import rubenpla.develop.privtmdbendlesslist.BR

class MovieBindModel : BaseObservable() {

    @get:Bindable
    var movieName: String = ""
        set(movieName) {
            field = movieName
            notifyPropertyChanged(BR.movieName)
        }

    @get:Bindable
    var yearOfMovie: String = ""
        set(yearOfMovie) {
            field = yearOfMovie
            notifyPropertyChanged(BR.yearOfMovie)
        }

    @get:Bindable
    var overview: String? = ""
        set(overview) {
            field = overview
            notifyPropertyChanged(BR.overview)
        }

    @get:Bindable
    var imageUrl: String? = ""
        set(imageUrl) {
            field = imageUrl
            notifyPropertyChanged(BR.imageUrl)
        }
}