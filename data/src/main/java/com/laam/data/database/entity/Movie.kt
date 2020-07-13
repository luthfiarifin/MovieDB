package com.laam.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.laam.data.database.entity.Movie.Companion.TABLE_NAME
import com.squareup.moshi.Json

/**
 * Created by luthfiarifin on 7/13/2020.
 */
@Entity(tableName = TABLE_NAME)
data class Movie(
    @PrimaryKey
    @Json(name = "id") val id: Int = 0,
    @Json(name = "adult") val adult: Boolean = false,
    @Json(name = "backdrop_path") val backdropPath: String? = null,
    @Json(name = "original_language") val originalLanguage: String? = null,
    @Json(name = "original_title") val originalTitle: String? = null,
    @Json(name = "overview") val overview: String? = null,
    @Json(name = "popularity") val popularity: Double = 0.0,
    @Json(name = "poster_path") val posterPath: String? = null,
    @Json(name = "release_date") val releaseDate: String? = null,
    @Json(name = "title") val title: String? = null,
    @Json(name = "video") val video: Boolean = false,
    @Json(name = "vote_average") val voteAverage: Double = 0.0,
    @Json(name = "vote_count") val voteCount: Int = 0
) {
    companion object {
        const val TABLE_NAME = "moviedb_movie"
    }
}