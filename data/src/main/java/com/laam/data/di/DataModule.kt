package com.laam.data.di

import android.app.Application
import com.laam.data.database.app.AppDatabase
import com.laam.data.database.dao.MoviesDao
import com.laam.data.network.routes.ApiService
import com.laam.database.Database
import com.laam.network.Network
import dagger.Module
import dagger.Provides

/**
 * Created by luthfiarifin on 7/13/2020.
 */
@Module
class DataModule {

    @Provides
    @NetworkScope
    fun provideApiService(): ApiService =
        Network.retrofitClient().create(ApiService::class.java)

    @Provides
    @DatabaseScope
    fun provideMoviesDao(application: Application): MoviesDao =
        Database.createRoomDatabase<AppDatabase>(application.applicationContext).getMoviesDao()
}