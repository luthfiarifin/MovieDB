package com.laam.moviedb.ui.detail

import android.os.Bundle
import androidx.lifecycle.Observer
import com.laam.moviedb.R
import com.laam.moviedb.databinding.ActivityDetailBinding
import com.laam.moviedb.ui.base.BaseActivity

/**
 * Created by luthfiarifin on 7/5/2020.
 */
class DetailActivity : BaseActivity<ActivityDetailBinding, DetailViewModel>() {

    override fun getViewModel(): Class<DetailViewModel> = DetailViewModel::class.java

    override fun getLayoutId(): Int = R.layout.activity_detail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBar(mViewBinding.toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        val movieId = intent?.extras?.getInt(MOVIE_ID)
            ?: throw IllegalArgumentException("movieId must be non-null")

        initialPost(movieId)
    }

    private fun initialPost(movieId: Int) {
        mViewModel.getMovie(movieId).observe(this, Observer {
            mViewBinding.data = it
        })
    }

    companion object {
        val MOVIE_ID = "movie_id"
    }
}