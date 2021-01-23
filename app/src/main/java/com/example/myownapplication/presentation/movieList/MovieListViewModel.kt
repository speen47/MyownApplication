package com.example.myownapplication.presentation.movieList

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myownapplication.domain.models.Movie
import com.example.myownapplication.domain.movie.MoviesInteractor
import com.example.myownapplication.domain.movie.MoviesInteractorImpl
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieListViewModel(val context: Context) : ViewModel() {


    private var movies = listOf<Movie>()

    private val moviesInteractor: MoviesInteractor = MoviesInteractorImpl(context)

    private val moviesLiveData: MutableLiveData<List<Movie>> = MutableLiveData(emptyList())
    val openMoviesLiveData: LiveData<List<Movie>> = moviesLiveData

    //          ЭТОТ СКОУП НЕ ПОДХОДИТ? КАК ТОГДА ОБРАБАТЫВАТЬ ОШИББКИ? ИЛИ ТАМ ВСЕ БУДЕТ АВТОМАТОМ?
    val handlerException = CoroutineExceptionHandler { coroutineContext, throwable ->
        Log.d("Mylog", "exception handled: ${throwable.message}")
    }
//    val coroutineContext = SupervisorJob() + Dispatchers.Default + handlerException
//    val coroutineScope = CoroutineScope(coroutineContext)


    fun getMovies() {
        viewModelScope.launch {
            val localMovies = withContext(Dispatchers.IO) {
                moviesInteractor.getMoviesFromDB()
            }
            if (localMovies.isNotEmpty()) {
                moviesLiveData.postValue(localMovies)
            }
            movies = withContext(Dispatchers.IO) {
                moviesInteractor.getMovies()
            }
            moviesLiveData.postValue(movies)
            moviesInteractor.addAllMoviesToDataBase(movies)

//            movies = moviesInteractor.getMovies()
//            moviesLiveData.postValue(movies)
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





