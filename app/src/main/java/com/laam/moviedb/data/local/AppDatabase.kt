package com.laam.moviedb.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.laam.moviedb.model.Movie

/**
 * Created by luthfiarifin on 7/4/2020.
 */
@Database(
    entities = [Movie::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        const val DB_NAME = "movie_database"

        fun create(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                DB_NAME
            ).build()
        }
    }
}