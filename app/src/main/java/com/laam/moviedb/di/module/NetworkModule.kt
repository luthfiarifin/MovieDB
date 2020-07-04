package com.laam.moviedb.di.module

import com.laam.moviedb.data.remote.api.ApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/**
 * Created by luthfiarifin on 7/4/2020.
 */
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofitInstance(): ApiService = ApiService.create()
}