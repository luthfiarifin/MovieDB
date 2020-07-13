package com.laam.abstraction.util.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.laam.abstraction.BuildConfig

/**
 * Created by luthfiarifin on 7/13/2020.
 */
object ImageBindingUtil {

    @BindingAdapter("imageMovieUrl")
    @JvmStatic
    fun bindImageMovieUrl(view: ImageView, url: String?) {
        url?.let {
            Glide.with(view.context)
                .load("${BuildConfig.BASE_IMAGE_URL}$it")
                .placeholder(android.R.color.white)
                .into(view)
        }
    }
}