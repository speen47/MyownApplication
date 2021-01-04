package com.example.myownapplication.data.network

import com.example.myownapplication.data.network.configuration.ConfigurationApi
import com.example.myownapplication.data.network.movie.MoviesApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.create

object RetrofitModule {
    private const val baseUrl = "https://api.themoviedb.org/3/"
    private val contentType = "application/json".toMediaType()

    private val json = Json {
        ignoreUnknownKeys = true
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(json.asConverterFactory(contentType))
        .build()

    val moviesApi: MoviesApi = retrofit.create()
    val configurationApi: ConfigurationApi = retrofit.create()
}

