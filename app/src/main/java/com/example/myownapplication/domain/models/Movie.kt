package com.example.myownapplication.domain.models

data class Movie(
    val id: Long,
    val title: String,
    val overview: String,
    val poster: String,
    val backdrop: String,
    val ratings: Float,
    val numberOfRatings: Long,
    val minimumAge: Int,
    val runtime: Long,
    val genres: List<Genre>,
    val actors: List<Actor>
)