package com.laam.moviedb.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.laam.moviedb.data.repository.MovieRepository
import com.laam.moviedb.model.Movie
import com.laam.moviedb.utils.State
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by luthfiarifin on 7/4/2020.
 */
class MainViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {

    private val _moviesLiveData = MutableLiveData<State<List<Movie>>>()

    val moviesLiveData: LiveData<State<List<Movie>>>
        get() = _moviesLiveData

    fun getMovies() {
        viewModelScope.launch {
            repository.getAllMovies().collect {
                _moviesLiveData.postValue(it)
            }
        }
    }

}
