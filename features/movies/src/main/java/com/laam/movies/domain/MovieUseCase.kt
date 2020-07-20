package com.laam.movies.domain

import com.laam.abstraction.util.state.State
import com.laam.data.database.entity.Movie
import com.laam.data.repository.movie.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by luthfiarifin on 7/20/2020.
 */
class MovieUseCase @Inject constructor(
    private val repository: MovieRepository
) {

    suspend fun getAllMovies(): Flow<State<List<Movie>>> =
        repository.getAllMovies()

}