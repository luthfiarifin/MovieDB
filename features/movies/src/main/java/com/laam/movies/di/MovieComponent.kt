package com.laam.movies.di

import com.laam.movies.ui.MovieModule
import com.laam.movies.ui.MovieViewModelModule
import dagger.Component

/**
 * Created by luthfiarifin on 8/10/2020.
 */
@MovieScope
@Component(
    modules = [
        MovieModule::class,
        MovieViewModelModule::class
    ]
)
interface MovieComponent {


}