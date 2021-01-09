package com.example.myownapplication.domain.movie

import com.example.myownapplication.data.repository.movie.MoviesRepository
import com.example.myownapplication.data.repository.movie.MoviesRepositoryImpl
import com.example.myownapplication.domain.models.Movie

class MoviesInteractorImpl : MoviesInteractor {
    private val repository: MoviesRepository = MoviesRepositoryImpl()
    override suspend fun getMovies(): List<Movie> {
        return repository.getMoviesFromNetwork().map { it.toDomain() }
    }

    override suspend fun getMovieDetails(id: Long): Movie {
        return repository.getMovieDetailsFromNetwork(id).toDomain()
    }
}