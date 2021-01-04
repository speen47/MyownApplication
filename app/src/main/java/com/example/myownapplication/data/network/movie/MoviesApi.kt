package com.example.myownapplication.data.network.movie

import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {
    @GET("movie/top_rated")
    suspend fun getMovies(
        @Query("api_key") apiKey: String = "3665b31fd404f52c0b2a531f39046153",
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1,
    ): MovieTopRatedDto
}
