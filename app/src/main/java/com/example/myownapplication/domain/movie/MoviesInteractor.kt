package com.example.myownapplication.domain.movie

import com.example.myownapplication.data.Movie

interface MoviesInteractor {
    suspend fun getMovies(): List<Movie>
    suspend fun getMovieDetails(id: Long): Movie
}