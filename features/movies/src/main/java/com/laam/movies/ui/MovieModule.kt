package com.laam.movies.ui

import com.laam.data.database.dao.MoviesDao
import com.laam.data.di.DataModule
import com.laam.data.di.DatabaseScope
import com.laam.data.di.NetworkScope
import com.laam.data.network.routes.ApiService
import com.laam.data.repository.movie.MovieRepository
import com.laam.data.repository.movie.MovieRepositoryImpl
import com.laam.movies.di.MovieScope
import com.laam.movies.domain.MovieUseCase
import dagger.Module
import dagger.Provides

/**
 * Created by luthfiarifin on 8/10/2020.
 */
@Module(includes = [DataModule::class])
class MovieModule {

    @MovieScope
    @Provides
    fun provideRepository(
        @DatabaseScope moviesDao: MoviesDao,
        @NetworkScope api: ApiService
    ) = MovieRepositoryImpl(moviesDao, api)

    @MovieScope
    @Provides
    fun provideUseCase(
        repository: MovieRepository
    ) = MovieUseCase(repository)
}