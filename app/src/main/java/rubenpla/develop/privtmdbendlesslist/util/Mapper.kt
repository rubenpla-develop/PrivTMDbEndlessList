package rubenpla.develop.privtmdbendlesslist.util

import rubenpla.develop.privtmdbendlesslist.bind.model.MovieBindModel
import rubenpla.develop.privtmdbendlesslist.data.model.MoviesResultsItem

/**
 * Copyright (c) 2017 Fueled. All rights reserved.
 * @author chetansachdeva on 24/09/17
 */

object Mapper {

    fun mapToMovieBindModelFromApi(movie: MoviesResultsItem?): MovieBindModel {
        val movieBindModel = MovieBindModel()
        movieBindModel.movieName = movie?.title!!
        movieBindModel.overview = movie?.overview
        movieBindModel.yearOfMovie = movie?.releaseDate!!
        return movieBindModel
    }
}