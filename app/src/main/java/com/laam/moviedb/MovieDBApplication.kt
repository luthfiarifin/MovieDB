package com.laam.moviedb

import com.laam.moviedb.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * Created by luthfiarifin on 7/4/2020.
 */
class MovieDBApplication : DaggerApplication (){
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.builder()
            .application(this)
            .build()
}
