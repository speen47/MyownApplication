package com.example.myownapplication.data.network.movie

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieTopRatedDto(
    val page: Int,
    val results: List<MovieDto>
)

@Serializable
data class MovieDto(
    val id: Int,
    val title: String,
    @SerialName("poster_path")
    val posterPicture: String,
    @SerialName("backdrop_path")
    val backdropPicture: String,
//            val runtime: Int,
    @SerialName("genre_ids")
    val genreIds: List<Int>,
//            val actors: List<Int>,
    @SerialName("vote_average")
    val ratings: Float,
    @SerialName("vote_count")
    val votesCount: Int,
    val overview: String,
    val adult: Boolean
)
