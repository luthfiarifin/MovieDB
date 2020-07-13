package com.laam.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.laam.data.database.entity.Movie
import kotlinx.coroutines.flow.Flow

/**
 * Created by luthfiarifin on 7/13/2020.
 */
@Dao
interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<Movie>)

    @Query("DELETE FROM ${Movie.TABLE_NAME}")
    fun deleteAllMovies()

    @Query("SELECT * FROM ${Movie.TABLE_NAME}")
    fun getAllMovies(): Flow<List<Movie>>

    @Query("SELECT * FROM ${Movie.TABLE_NAME} WHERE id = :id")
    fun getMovieById(id: Int): Flow<Movie>

}