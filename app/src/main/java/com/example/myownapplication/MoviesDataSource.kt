package com.example.myownapplication

class MoviesDataSource {
    fun getMovies(): List<Movie> {
        return listOf(
            Movie(
                backgroundImage = R.drawable.img_movie,
                ageLimitation = "13+",
                genre = "Action, Adventure, Drama",
                countOfStarsOnRatingBar = "4",
                countOfReviews = "125 reviews",
                title = "Avengers: End Game",
                duration = "137 min"
            ),
            Movie(
                backgroundImage = R.drawable.img_tenet,
                ageLimitation = "16+",
                genre = "Action, Sci-Fi, Thriller",
                countOfStarsOnRatingBar = "5",
                countOfReviews = "98 reviews",
                title = "Tenet",
                duration = "97 min"
            ),
            Movie(
                backgroundImage = R.drawable.img_blackwidow,
                ageLimitation = "13+",
                genre = "Action, Adventure, Sci-Fi",
                countOfStarsOnRatingBar = "4",
                countOfReviews = "38 reviews",
                title = "Black Widow",
                duration = "102 min"
            ),
            Movie(
                backgroundImage = R.drawable.img_wonderwoman,
                ageLimitation = "13+",
                genre = "Action, Adventure, Fantasy",
                countOfStarsOnRatingBar = "5",
                countOfReviews = "74 reviews",
                title = "Wonder Woman 1984",
                duration = "120 min"
            )
        )
    }
}