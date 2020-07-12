package com.laam.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by luthfiarifin on 7/12/2020.
 */
object Network {

    fun retrofitClient(url: String = BuildConfig.BASE_URL): Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient())
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
                )
            )
            .build()

    private fun okHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(NetworkInterceptor())
            .build()

}
