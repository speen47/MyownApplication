package com.example.myownapplication.data.repository.movie

import com.example.myownapplication.data.network.movie.MovieDto

interface MoviesRepository {
    suspend fun getMoviesFromNetwork(): List<MovieDto>
}