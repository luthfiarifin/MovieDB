package com.laam.moviedb.ui.detail

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity

/**
 * Created by luthfiarifin on 7/5/2020.
 */
class DetailActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    companion object {
        val POST_ID = "post_id"
    }
}