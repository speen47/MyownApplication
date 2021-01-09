package com.example.myownapplication.presentation.movieDetails

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myownapplication.domain.actor.ActorsInteractor
import com.example.myownapplication.domain.actor.ActorsInteractorImpl
import com.example.myownapplication.domain.models.Actor
import com.example.myownapplication.domain.models.Movie
import com.example.myownapplication.domain.movie.MoviesInteractor
import com.example.myownapplication.domain.movie.MoviesInteractorImpl
import kotlinx.coroutines.*

class MovieDetailsViewModel() : ViewModel() {

    private var actors = listOf<Actor>()

    private val movieInteractor: MoviesInteractor = MoviesInteractorImpl()
    private val actorsInteractor: ActorsInteractor = ActorsInteractorImpl()

    private val moviesLiveData: MutableLiveData<Movie?> = MutableLiveData(null)
    val openMoviesLiveData: LiveData<Movie?> = moviesLiveData

    private val actorsLiveData: MutableLiveData<List<Actor>> = MutableLiveData(emptyList())
    val openActorsLiveData: LiveData<List<Actor>> = actorsLiveData

    //          ЭТОТ СКОУП НЕ ПОДХОДИТ? КАК ТОГДА ОБРАБАТЫВАТЬ ОШИББКИ? ИЛИ ТАМ ВСЕ БУДЕТ АВТОМАТОМ?
    val handlerException = CoroutineExceptionHandler { coroutineContext, throwable ->
        Log.d("Mylog", "exception handled: ${throwable.message}")
    }
    val coroutineContext = SupervisorJob() + Dispatchers.Default + handlerException
    val coroutineScope = CoroutineScope(coroutineContext)

    fun getMovieDetails(id: Long) {
        coroutineScope.launch {
            moviesLiveData.postValue(movieInteractor.getMovieDetails(id))
        }
    }

    fun getActors(id: Long) {
        coroutineScope.launch {
            actorsLiveData.postValue(actorsInteractor.getActors(id))
        }
    }
}