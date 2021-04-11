package com.ellison.dagger2demo.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.ellison.dagger2demo.model.MovieRepository
import com.ellison.dagger2demo.DemoActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieViewModel @Inject constructor(
        private val movieRepository: MovieRepository
) {
    private val resultData = MutableLiveData<String>()

    fun searchMovie(keyWorld: String, demoActivity: DemoActivity, observer: Observer<String>) {
        Log.d("Dagger", "searchMovie() movieRepository:$movieRepository")
        resultData.observe(demoActivity, observer)

        var result = ""
        GlobalScope.launch(Dispatchers.Main) {
            Log.d("Dagger", "searchMovie() searchMovieFromNetwork keyWorld:$keyWorld")
            val response = movieRepository.searchMovieFromNetwork(keyWorld)

            result = response.toString()
            Log.d("Dagger", "searchMovie() searchMovieFromNetwork result:$result")
            resultData.postValue(result)
        }
    }
}