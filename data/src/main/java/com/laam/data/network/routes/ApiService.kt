package com.laam.data.network.routes

import com.laam.data.network.result.MoviesResult
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by luthfiarifin on 7/13/2020.
 */
interface ApiService {

    @GET("movie/popular")
    suspend fun getMoviesPopular(): Response<MoviesResult>
}