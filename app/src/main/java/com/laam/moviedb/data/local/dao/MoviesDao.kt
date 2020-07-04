package com.laam.moviedb.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.laam.moviedb.model.Movie
import kotlinx.coroutines.flow.Flow

/**
 * Created by luthfiarifin on 7/4/2020.
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