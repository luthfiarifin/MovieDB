package com.laam.data.repository.movie_detail

import com.laam.data.database.entity.Movie
import kotlinx.coroutines.flow.Flow

/**
 * Created by luthfiarifin on 7/13/2020.
 */
interface MovieDetailRepository {

    suspend fun getMovieDetail(movieId: Int): Flow<Movie>
}