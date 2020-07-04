package com.laam.moviedb.data.remote.api

import com.laam.moviedb.BuildConfig
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by luthfiarifin on 7/4/2020.
 */
interface ApiService {

    companion object Factory {
        fun create(): ApiService {
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor { addQueryParam(it) }
                .build()

            return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(
                    MoshiConverterFactory.create(
                        Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
                    )
                )
                .build()
                .create(ApiService::class.java)
        }

        private fun addQueryParam(it: Interceptor.Chain): Response {
            var request = it.request()
            val url = request.url()
                .newBuilder()
                .addQueryParameter("api_key", BuildConfig.MOVIE_DB_KEY)
                .build()
            request = request.newBuilder()
                .url(url)
                .build()
            return it.proceed(request)
        }
    }
}