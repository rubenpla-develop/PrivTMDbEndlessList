package rubenpla.develop.privtmdbendlesslist.data.api

import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import rubenpla.develop.privtmdbendlesslist.data.model.MoviesResponse

/**
 * Created by alten on 14/2/18.
 */
interface TmdbApi {

    @GET("movie/popular")
    fun getPopularMovies(@Query("api_key") api_key: String,
                         @Query("page") page: Int): Flowable<MoviesResponse>


    /*companion object Factory {
        @Volatile
        private var retrofit : Retrofit? = null

        private const val BASE_URL: String = "https://api.themoviedb.org/3/"

        @Synchronized
        fun getInstance(): TmdbApi? {
            retrofit ?: synchronized(this) {
                retrofit ?: buildRetrofit()
            }

            return retrofit?.create(TmdbApi::class.java)
        }

        private fun buildRetrofit() = retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}*/
    companion object Factory {
        private const val BASE_URL: String = "https://api.themoviedb.org/3/"

        fun getInstance(): TmdbApi {

            val retrofit = retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory
                            .createWithScheduler(Schedulers.io()))
                    .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
                    .build()

            return retrofit.create(TmdbApi::class.java)
        }
    }
}