package com.laam.data.database.app

import androidx.room.Database
import androidx.room.RoomDatabase
import com.laam.data.database.dao.MoviesDao
import com.laam.data.database.entity.Movie

/**
 * Created by luthfiarifin on 7/13/2020.
 */
@Database(
    entities = [Movie::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getMoviesDao(): MoviesDao
}