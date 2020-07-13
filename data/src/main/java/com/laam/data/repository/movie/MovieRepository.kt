package com.laam.data.repository.movie

import com.laam.abstraction.util.state.State
import com.laam.data.database.entity.Movie
import kotlinx.coroutines.flow.Flow

/**
 * Created by luthfiarifin on 7/13/2020.
 */
interface MovieRepository {

    suspend fun getAllMovies(): Flow<State<List<Movie>>>
}