package com.laam.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Created by luthfiarifin on 7/13/2020.
 */
object Database {
    const val DB_NAME = "movie_database"

    inline fun <reified T : RoomDatabase> createRoomDatabase(context: Context): T =
        Room.databaseBuilder(
            context,
            T::class.java,
            DB_NAME
        ).build()
}