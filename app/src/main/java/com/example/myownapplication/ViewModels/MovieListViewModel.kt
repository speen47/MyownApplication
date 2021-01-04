package com.example.myownapplication.ViewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myownapplication.data.Movie
import com.example.myownapplication.domain.movie.MoviesInteractor
import com.example.myownapplication.domain.movie.MoviesInteractorImpl
import kotlinx.coroutines.*

class MovieListViewModel() : ViewModel() {


    private var movies = listOf<Movie>()

    private val moviesInteractor: MoviesInteractor = MoviesInteractorImpl()

    private val moviesLiveData: MutableLiveData<List<Movie>> = MutableLiveData(emptyList())
    val openMoviesLiveData: LiveData<List<Movie>> = moviesLiveData

    //          ЭТОТ СКОУП НЕ ПОДХОДИТ? КАК ТОГДА ОБРАБАТЫВАТЬ ОШИББКИ? ИЛИ ТАМ ВСЕ БУДЕТ АВТОМАТОМ?
    val handlerException = CoroutineExceptionHandler { coroutineContext, throwable ->
        Log.d("Mylog", "exception handled: ${throwable.message}")
    }
    val coroutineContext = SupervisorJob() + Dispatchers.Default + handlerException
    val coroutineScope = CoroutineScope(coroutineContext)


    fun getMovies() {
        coroutineScope.launch {
            movies = moviesInteractor.getMovies()
            moviesLiveData.postValue(movies)
        }
    }

//    fun getMovies() {
//        viewModelScope.launch {
//            movies = loadMovies()
//
//            moviesLiveData.value = movies
//        }
//    }
}





