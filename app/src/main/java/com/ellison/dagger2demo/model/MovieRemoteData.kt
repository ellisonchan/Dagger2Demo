package com.ellison.dagger2demo.model

import android.util.Log
import com.ellison.dagger2demo.bean.Movie
import com.ellison.dagger2demo.bean.MovieResponse
import javax.inject.Inject

class MovieRemoteData @Inject constructor(private val movieService: MovieService) {
    suspend fun searchMovie(keyWorld: String): MovieResponse<List<Movie>> {
        Log.d("Dagger", "searchMovie() movieService:$movieService")
        return movieService.requestSearchByCoroutines(keyWorld, "19b0bce5")
    }
}