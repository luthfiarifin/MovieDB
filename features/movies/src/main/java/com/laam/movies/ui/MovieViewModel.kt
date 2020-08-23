package com.laam.movies.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.laam.abstraction.base.BaseViewModel
import com.laam.abstraction.util.state.State
import com.laam.data.database.entity.Movie
import com.laam.movies.domain.MovieUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by luthfiarifin on 8/23/2020.
 */
interface MovieContract {
    fun getMovies()
}

class MovieViewModel @Inject constructor(
    private val useCase: MovieUseCase
) : BaseViewModel(), MovieContract {

    private val _moviesLiveData = MutableLiveData<State<List<Movie>>>()
    val moviesLiveData: LiveData<State<List<Movie>>>
        get() = _moviesLiveData

    init {
        getMovies()
    }

    override fun getMovies() {
        viewModelScope.launch {
            useCase.getAllMovies().collect {
                _moviesLiveData.postValue(it)
            }
        }
    }

}
