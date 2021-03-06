package rubenpla.develop.privtmdbendlesslist.data.repository

import io.reactivex.Flowable
import rubenpla.develop.privtmdbendlesslist.data.api.TmdbApi
import rubenpla.develop.privtmdbendlesslist.data.model.MoviesResponse

class PopularMoviesRepository(private val apiService: TmdbApi?) {

    fun getPopularMoviesFromApi(key: String, page: Int): Flowable<MoviesResponse>? {
        return apiService?.getPopularMovies(key, page)
    }
}