package rubenpla.develop.privtmdbendlesslist.data.repository

import io.reactivex.Flowable
import rubenpla.develop.privtmdbendlesslist.data.api.TmdbApi
import rubenpla.develop.privtmdbendlesslist.data.model.MoviesResponse

class SearchMoviesRepository (private val apiService: TmdbApi?) {

    fun searchMoviesFromApi(key: String, query : String, page: Int): Flowable<MoviesResponse>? {
        return apiService?.searchMovies(key, query, page)
    }
}