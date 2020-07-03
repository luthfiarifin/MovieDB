package com.laam.moviedb.di.builder

import com.laam.moviedb.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by luthfiarifin on 7/4/2020.
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
}