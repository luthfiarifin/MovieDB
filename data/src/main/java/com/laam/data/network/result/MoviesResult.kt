package com.laam.data.network.result

import com.laam.data.database.entity.Movie

/**
 * Created by luthfiarifin on 7/13/2020.
 */
data class MoviesResult(
    val page: Int,
    val total_pages: Int,
    val total_results: Int,
    val results: List<Movie>
)