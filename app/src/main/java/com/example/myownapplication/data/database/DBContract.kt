package com.example.myownapplication.data.database

object DBContract {
    const val DATABASE_NAME = "Films.db"

    object MoviesList {
        const val TABLE_NAME = "movies_list"

        const val COLUMN_NAME_ID = "id"
        const val COLUMN_NAME_TITLE = "title"
        const val COLUMN_NAME_POSTER = "poster"
        const val COLUMN_NAME_RATINGS = "ratings"
        const val COLUMN_NAME_MINIMUM_AGE = "minimumAge"
    }
}