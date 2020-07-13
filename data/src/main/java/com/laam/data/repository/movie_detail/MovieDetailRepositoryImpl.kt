package com.laam.data.repository.movie_detail

import com.laam.data.database.dao.MoviesDao
import com.laam.data.database.entity.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by luthfiarifin on 7/13/2020.
 */
class MovieDetailRepositoryImpl @Inject constructor(
    val moviesDao: MoviesDao
): MovieDetailRepository {

    override suspend fun getMovieDetail(movieId: Int): Flow<Movie> =
        moviesDao.getMovieById(movieId)
}
