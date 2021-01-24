package com.example.myownapplication.data.network

import com.example.myownapplication.data.network.actor.ActorsApi
import com.example.myownapplication.data.network.configuration.ConfigurationApi
import com.example.myownapplication.data.network.movie.MoviesApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.create

object RetrofitModule {
    private const val baseUrl = "https://api.themoviedb.org/3/"
    private val contentType = "application/json".toMediaType()

    private val json = Json {
        ignoreUnknownKeys = true
    }

    private val interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    private val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(json.asConverterFactory(contentType))
        .client(client)
        .build()

    val moviesApi: MoviesApi = retrofit.create()
    val configurationApi: ConfigurationApi = retrofit.create()
    val actorsApi: ActorsApi = retrofit.create()
}

