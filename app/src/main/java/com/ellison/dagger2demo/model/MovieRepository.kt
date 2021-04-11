package com.ellison.dagger2demo.model

import android.util.Log
import com.ellison.dagger2demo.bean.Movie
import com.ellison.dagger2demo.bean.MovieResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(
        private val localData: MovieLocalData,
        private val remoteData: MovieRemoteData
) {
    suspend fun searchMovieFromNetwork(keyWorld: String): MovieResponse<List<Movie>> {
        Log.d("Dagger", "searchMovieFromNetwork() remoteData:$remoteData")
        return remoteData.searchMovie(keyWorld)
    }
}