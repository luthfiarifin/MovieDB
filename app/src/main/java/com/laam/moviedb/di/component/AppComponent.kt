package com.laam.moviedb.di.component

import android.app.Application
import com.laam.moviedb.MovieDBApplication
import com.laam.moviedb.di.builder.ActivityBuilder
import com.laam.moviedb.di.module.NetworkModule
import com.laam.moviedb.di.module.ViewModelFactoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

/**
 * Created by luthfiarifin on 7/4/2020.
 */
@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        NetworkModule::class,
        ActivityBuilder::class,
        ViewModelFactoryModule::class
    ]
)
interface AppComponent : AndroidInjector<MovieDBApplication> {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}
