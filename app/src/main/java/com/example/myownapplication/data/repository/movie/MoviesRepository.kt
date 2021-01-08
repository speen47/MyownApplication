package com.example.myownapplication.data.repository.movie

import com.example.myownapplication.data.network.movie.MovieDetailsDto
import com.example.myownapplication.data.network.movie.MovieDto

interface MoviesRepository {
    suspend fun getMoviesFromNetwork(): List<MovieDto>
    suspend fun getMovieDetailsFromNetwork(id: Long): MovieDetailsDto
}