package com.example.myownapplication.data.database.movieslist

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myownapplication.data.database.DBContract

@Entity(tableName = DBContract.MoviesList.TABLE_NAME)
data class MoviesListEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Long,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "poster")
    val poster: String,

    @ColumnInfo(name = "ratings")
    val ratings: Float,

    @ColumnInfo(name = "minimumAge")
    val minimumAge: Int
)
