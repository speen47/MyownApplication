package com.example.myownapplication.presentation


import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myownapplication.presentation.movieDetails.MovieDetailsViewModel
import com.example.myownapplication.presentation.movieList.MovieListViewModel

class ViewModelFactory(val context: Context) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when (modelClass) {
        MovieListViewModel::class.java -> MovieListViewModel(context)
        MovieDetailsViewModel::class.java -> MovieDetailsViewModel(context)
        else -> throw IllegalArgumentException("$modelClass is not registered ViewModel")
    } as T
}