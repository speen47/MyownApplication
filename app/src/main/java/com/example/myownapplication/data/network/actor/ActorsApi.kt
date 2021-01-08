package com.example.myownapplication.data.network.actor

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ActorsApi {
    @GET("movie/{movie_id}/credits")
    suspend fun getActors(
            @Path("movie_id") id: Long,
            @Query("api_key") apiKey: String = "3665b31fd404f52c0b2a531f39046153",
            @Query("language") language: String = "en-US",
    ): ActorsDto
}