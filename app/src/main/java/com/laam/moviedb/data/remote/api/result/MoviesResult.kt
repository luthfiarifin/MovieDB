package com.laam.moviedb.data.remote.api.result

import com.laam.moviedb.model.Movie

/**
 * Created by luthfiarifin on 7/4/2020.
 */
data class MoviesResult(
    val page: Int,
    val total_pages: Int,
    val total_results: Int,
    val results: List<Movie>
)