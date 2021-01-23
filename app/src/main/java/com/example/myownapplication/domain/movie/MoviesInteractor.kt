package com.example.myownapplication.domain.movie

import com.example.myownapplication.domain.models.Movie

interface MoviesInteractor {
    suspend fun getMovies(): List<Movie>
    suspend fun getMovieDetails(id: Long): Movie

    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun addAllMoviesToDataBase(movies: List<Movie>)
}