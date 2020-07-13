package com.laam.data.repository.movie

import com.laam.abstraction.util.network.NetworkBoundRepository
import com.laam.abstraction.util.state.State
import com.laam.data.database.dao.MoviesDao
import com.laam.data.database.entity.Movie
import com.laam.data.network.result.MoviesResult
import com.laam.data.network.routes.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by luthfiarifin on 7/13/2020.
 */
class MovieRepositoryImpl @Inject constructor(
    val moviesDao: MoviesDao,
    val apiService: ApiService
) : MovieRepository {
    override suspend fun getAllMovies(): Flow<State<List<Movie>>> =
        object : NetworkBoundRepository<List<Movie>, MoviesResult>() {
            override suspend fun saveRemoteData(response: MoviesResult) =
                moviesDao.insertMovies(response.results)

            override suspend fun fetchFromLocal(): Flow<List<Movie>> =
                moviesDao.getAllMovies()

            override suspend fun fetchFromRemote(): Response<MoviesResult> =
                apiService.getMoviesPopular()

        }.asFlow().flowOn(Dispatchers.IO)
}
