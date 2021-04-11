package com.ellison.dagger2demo.model

import com.ellison.dagger2demo.bean.Movie
import com.ellison.dagger2demo.bean.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("http://omdbapi.com/")
    suspend fun requestSearchByCoroutines(
            @Query("s") keywords: String,
            @Query("apikey") apikey: String
    ): MovieResponse<List<Movie>>
}