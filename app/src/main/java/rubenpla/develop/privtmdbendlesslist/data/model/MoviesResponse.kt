package rubenpla.develop.privtmdbendlesslist.data.model

import com.google.gson.annotations.SerializedName

data class MoviesResponse(

        @SerializedName("page")
        val page: Int? = null,

        @SerializedName("total_pages")
        val totalPages: Int? = null,

        @SerializedName("results")
        val results: List<MoviesResultsItem?>? = null,

        @SerializedName("total_results")
        val totalResults: Int? = null
)