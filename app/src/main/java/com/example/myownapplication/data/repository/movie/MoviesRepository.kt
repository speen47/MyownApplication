package com.example.myownapplication.data.repository.movie

import com.example.myownapplication.data.database.movieslist.MoviesListEntity
import com.example.myownapplication.data.network.movie.MovieDetailsDto
import com.example.myownapplication.data.network.movie.MovieDto

interface MoviesRepository {
    suspend fun getMoviesFromNetwork(): List<MovieDto>
    suspend fun getMovieDetailsFromNetwork(id: Long): MovieDetailsDto

    suspend fun getMoviesFromDataBase(): List<MoviesListEntity>
    suspend fun addAllMoviesToDataBase(movies: List<MoviesListEntity>)
}