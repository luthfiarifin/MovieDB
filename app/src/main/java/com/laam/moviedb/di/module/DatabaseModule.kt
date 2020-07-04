package com.laam.moviedb.di.module

import android.app.Application
import com.laam.moviedb.data.local.AppDatabase
import com.laam.moviedb.data.local.dao.MoviesDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by luthfiarifin on 7/4/2020.
 */
@Module
abstract class DatabaseModule {

    @Singleton
    @Provides
    fun provideRoomInstance(application: Application): AppDatabase =
        AppDatabase.create(application.applicationContext)

    @Singleton
    @Provides
    fun provideMoviesDao(appDatabase: AppDatabase): MoviesDao =
        appDatabase.getMoviesDao()
}