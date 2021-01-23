package com.example.myownapplication.data.database.movieslist

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MoviesListDAO {
    @Query("SELECT  * FROM movies_list")
    suspend fun getAll(): List<MoviesListEntity>

    @Insert
    suspend fun insertAll(films: List<MoviesListEntity>)
}