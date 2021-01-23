package com.example.myownapplication.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myownapplication.data.database.movieslist.MoviesListDAO
import com.example.myownapplication.data.database.movieslist.MoviesListEntity

@Database(entities = [MoviesListEntity::class], version = 1)
abstract class DataBase : RoomDatabase() {

    abstract val moviesListDao: MoviesListDAO

    companion object {
        fun create(context: Context): DataBase {
            return Room.databaseBuilder(
                context,
                DataBase::class.java,
                DBContract.DATABASE_NAME
            )
                .fallbackToDestructiveMigration()
                .build()
        }

    }
}