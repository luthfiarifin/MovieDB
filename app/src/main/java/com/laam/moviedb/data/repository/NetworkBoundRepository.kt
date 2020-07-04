package com.laam.moviedb.data.repository

import com.laam.moviedb.utils.State
import kotlinx.coroutines.flow.*
import retrofit2.Response

/**
 * Created by luthfiarifin on 7/4/2020.
 */
abstract class NetworkBoundRepository<RESULT, REQUEST> {

    fun asFlow() = flow<State<RESULT>> {
        emit(State.loading())

        try {
            // Emit from database first
            emit(State.success(fetchFromLocal().first()))

            val apiResponse = fetchFromRemote()

            val remoteMovies = apiResponse.body()

            if (apiResponse.isSuccessful && remoteMovies != null) {
                saveRemoteData(remoteMovies)
            } else {
                emit(State.error(apiResponse.message()))
            }
        } catch (e: Exception) {
            emit(State.error("Network error!"))
            e.printStackTrace()
        }

        emitAll(fetchFromLocal().map {
            State.success(it)
        })
    }

    protected abstract suspend fun saveRemoteData(response: REQUEST)

    protected abstract suspend fun fetchFromLocal(): Flow<RESULT>

    protected abstract suspend fun fetchFromRemote(): Response<REQUEST>

}