package rubenpla.develop.privtmdbendlesslist.util

import rubenpla.develop.privtmdbendlesslist.bind.model.MovieBindModel
import rubenpla.develop.privtmdbendlesslist.data.model.MoviesResultsItem
import rubenpla.develop.privtmdbendlesslist.util.JodaTimeConverter.Companion.jodaTimeInstance

object Mapper {

    fun mapToMovieBindModelFromApi(movie: MoviesResultsItem?): MovieBindModel {
        val movieBindModel = MovieBindModel()
        movieBindModel.movieName = movie?.title!!
        movieBindModel.overview = movie.overview
        movieBindModel.yearOfMovie = mapYearOfMovieToJustYear(movie.releaseDate!!)
        movieBindModel.imageUrl = mapImageUrlToDrawable(movie.posterPath)
        return movieBindModel
    }

   private fun mapImageUrlToDrawable(urlPosterPath: String? ) : String? {
       val urlBase = "https://image.tmdb.org/t/p/w500"

       return urlBase + urlPosterPath
   }

    private fun mapYearOfMovieToJustYear(date : String) : String {
        val date = jodaTimeInstance.getYearFromDate(date)

        return date.toString()
    }
}