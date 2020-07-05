package com.laam.moviedb.di.builder

import com.laam.moviedb.ui.detail.DetailActivity
import com.laam.moviedb.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by luthfiarifin on 7/4/2020.
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun bindDetailActivity(): DetailActivity
}