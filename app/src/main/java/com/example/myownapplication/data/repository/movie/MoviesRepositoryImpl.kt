package com.example.myownapplication.data.repository.movie

import com.example.myownapplication.data.network.RetrofitModule
import com.example.myownapplication.data.network.movie.MovieDetailsDto
import com.example.myownapplication.data.network.movie.MovieDto

class MoviesRepositoryImpl : MoviesRepository {
    override suspend fun getMoviesFromNetwork(): List<MovieDto> {
        val baseUrl = RetrofitModule.configurationApi.getConfiguration().images.baseUrl
        val result = RetrofitModule.moviesApi.getMovies().results
        return result.map {
            it.copy(
                    posterPicture = baseUrl + "original" + it.posterPicture
//                backdropPicture = baseUrl + "original" + it.backdropPicture
            )
        }
    }

    override suspend fun getMovieDetailsFromNetwork(id: Long): MovieDetailsDto {
        val baseUrl = RetrofitModule.configurationApi.getConfiguration().images.baseUrl
        val movie = RetrofitModule.moviesApi.getMovieDetails(id = id)
        val backdropPath = movie.backdropPath
        movie.backdropPath = baseUrl + "original" + backdropPath
        return movie
    }
}