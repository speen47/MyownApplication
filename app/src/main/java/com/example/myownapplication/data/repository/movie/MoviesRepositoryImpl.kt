package com.example.myownapplication.data.repository.movie

import com.example.myownapplication.data.network.RetrofitModule
import com.example.myownapplication.data.network.movie.MovieDto

class MoviesRepositoryImpl : MoviesRepository {
    override suspend fun getMoviesFromNetwork(): List<MovieDto> {
        val baseUrl = RetrofitModule.configurationApi.getConfiguration().images.baseUrl
        val result = RetrofitModule.moviesApi.getMovies().results
        return result.map {
            it.copy(
                posterPicture = baseUrl + "original" + it.posterPicture,
                backdropPicture = baseUrl + "original" + it.backdropPicture
            )
        }
    }
}