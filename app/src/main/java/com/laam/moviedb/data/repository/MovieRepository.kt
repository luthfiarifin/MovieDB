package com.laam.moviedb.data.repository

import com.laam.moviedb.data.local.dao.MoviesDao
import com.laam.moviedb.data.remote.api.ApiService
import com.laam.moviedb.data.remote.api.result.MoviesResult
import com.laam.moviedb.model.Movie
import com.laam.moviedb.utils.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by luthfiarifin on 7/4/2020.
 */
@Singleton
class MovieRepository @Inject constructor(
    private val moviesDao: MoviesDao,
    private val apiService: ApiService
) {

    fun getAllMovies(): Flow<State<List<Movie>>> {
        return object : NetworkBoundRepository<List<Movie>, MoviesResult>() {
            override suspend fun saveRemoteData(response: MoviesResult) =
                moviesDao.insertMovies(response.results)

            override suspend fun fetchFromLocal(): Flow<List<Movie>> =
                moviesDao.getAllMovies()

            override suspend fun fetchFromRemote(): Response<MoviesResult> =
                apiService.getMoviesPopular()

        }.asFlow().flowOn(Dispatchers.IO)
    }

    fun getMovieById(movieId: Int) = moviesDao.getMovieById(movieId)
}