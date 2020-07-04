package com.laam.moviedb.ui.main

import androidx.lifecycle.ViewModel
import com.laam.moviedb.data.repository.MovieRepository
import javax.inject.Inject

/**
 * Created by luthfiarifin on 7/4/2020.
 */
class MainViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {
}