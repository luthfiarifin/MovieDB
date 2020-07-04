package com.laam.moviedb.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.laam.moviedb.BuildConfig

/**
 * Created by luthfiarifin on 7/5/2020.
 */
object ImageBindingUtil {

    @BindingAdapter("imageMovieUrl")
    fun bindImageMovieUrl(view: ImageView, url: String?) {
        url?.let {
            Glide.with(view.context)
                .load("${BuildConfig.BASE_IMAGE_URL}$it")
                .into(view)
        }
    }
}