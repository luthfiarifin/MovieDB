package com.laam.moviedb.ui.detail

import androidx.lifecycle.ViewModel
import com.laam.moviedb.data.repository.MovieRepository
import javax.inject.Inject

/**
 * Created by luthfiarifin on 7/5/2020.
 */
class DetailViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {

}