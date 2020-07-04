package com.laam.moviedb.di.module

import androidx.lifecycle.ViewModelProvider
import com.laam.moviedb.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
interface ViewModelFactoryModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory
}