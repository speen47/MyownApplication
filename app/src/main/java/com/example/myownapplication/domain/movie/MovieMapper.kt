package com.example.myownapplication.domain.movie

import com.example.myownapplication.data.database.movieslist.MoviesListEntity
import com.example.myownapplication.data.network.movie.GenreDto
import com.example.myownapplication.data.network.movie.MovieDetailsDto
import com.example.myownapplication.data.network.movie.MovieDto
import com.example.myownapplication.domain.models.Genre
import com.example.myownapplication.domain.models.Movie

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

fun MovieDetailsDto.toDomain(): Movie {
    return Movie(
            id = this.id,
            title = this.title,
            overview = this.overview,
            poster = this.posterPath ?: "",
            backdrop = this.backdropPath,
            ratings = this.voteAverage.toFloat(),
            numberOfRatings = this.voteCount,
            minimumAge = if (this.adult) 16 else 13,
            runtime = this.runtime,
            genres = this.genres.map { it.toDomain() },
            actors = emptyList(), //TODO
    )
}

fun MoviesListEntity.toDomain(): Movie {
        return Movie(
                id = this.id,
                title = this.title,
                overview = "owerview", //TODO()
                poster = this.poster,
                backdrop = "backDrop", //TODO()
                ratings = this.ratings,
                numberOfRatings = 1000, //TODO()
                minimumAge = this.minimumAge,
                runtime = 0, //TODO()
                genres = emptyList(), // TODO()
                actors = emptyList(), //TODO
        )
}

fun Movie.toEntity(): MoviesListEntity {
        return MoviesListEntity(
                id = this.id,
                title = this.title,
                poster = this.poster,
                ratings = this.ratings,
                minimumAge = this.minimumAge
        )
}

fun GenreDto.toDomain() = Genre(id = this.id, name = this.name)