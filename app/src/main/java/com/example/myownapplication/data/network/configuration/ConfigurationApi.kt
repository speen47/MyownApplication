package com.example.myownapplication.data.network.configuration

import retrofit2.http.GET
import retrofit2.http.Query

interface ConfigurationApi {
    @GET("configuration")
    suspend fun getConfiguration(
        @Query("api_key") apiKey: String = "3665b31fd404f52c0b2a531f39046153",
    ): ConfigurationDto
}