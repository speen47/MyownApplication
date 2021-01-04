package com.example.myownapplication.ViewModels


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when (modelClass) {
        MovieListViewModel::class.java -> MovieListViewModel()
        MovieDetailsViewModel::class.java -> MovieDetailsViewModel()
        else -> throw IllegalArgumentException("$modelClass is not registered ViewModel")
    } as T
}