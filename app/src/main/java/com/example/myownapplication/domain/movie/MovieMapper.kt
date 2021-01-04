package com.example.myownapplication.domain.movie

import com.example.myownapplication.data.Movie
import com.example.myownapplication.data.network.movie.MovieDto

fun MovieDto.toDomain(): Movie {
    return Movie(
        id = this.id,
        title = this.title,
        overview = this.overview,
        poster = this.posterPicture,
        backdrop = this.backdropPicture,
        ratings = this.ratings,
        numberOfRatings = this.votesCount,
        minimumAge = if (this.adult) 16 else 13,
        runtime = 0, //TODO()
        genres = emptyList(), // TODO()
        actors = emptyList(), //TODO
    )
}