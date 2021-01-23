package com.example.myownapplication.domain.movie

import android.content.Context
import com.example.myownapplication.data.repository.movie.MoviesRepository
import com.example.myownapplication.data.repository.movie.MoviesRepositoryImpl
import com.example.myownapplication.domain.models.Movie

class MoviesInteractorImpl(private val context: Context) : MoviesInteractor {
    private val repository: MoviesRepository = MoviesRepositoryImpl(context)
    override suspend fun getMovies(): List<Movie> {
        return repository.getMoviesFromNetwork().map { it.toDomain() }
    }

    override suspend fun getMovieDetails(id: Long): Movie {
        return repository.getMovieDetailsFromNetwork(id).toDomain()
    }

    override suspend fun getMoviesFromDB(): List<Movie> {
        return repository.getMoviesFromDataBase().map { it.toDomain() }
    }

    override suspend fun addAllMoviesToDataBase(movies: List<Movie>) {
        repository.addAllMoviesToDataBase(movies.map { it.toEntity() })
    }
}