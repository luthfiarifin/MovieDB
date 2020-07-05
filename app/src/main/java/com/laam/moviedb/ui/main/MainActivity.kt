package com.laam.moviedb.ui.main

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.laam.moviedb.R
import com.laam.moviedb.databinding.ActivityMainBinding
import com.laam.moviedb.model.Movie
import com.laam.moviedb.ui.base.BaseActivity
import com.laam.moviedb.ui.detail.DetailActivity
import com.laam.moviedb.ui.main.adapter.MovieListAdapter
import com.laam.moviedb.utils.NetworkUtils
import com.laam.moviedb.utils.State

/**
 * Created by luthfiarifin on 7/4/2020.
 */
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(),
    MovieListAdapter.OnItemClickListener {

    private val mRvAdapter by lazy { MovieListAdapter(this) }

    override fun getViewModel(): Class<MainViewModel> = MainViewModel::class.java

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()

        initMovies()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            handleNetworkChange()
        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun handleNetworkChange() {
        NetworkUtils.getNetworkLiveData(applicationContext).observe(this, Observer { isConnected ->
            if (!isConnected) {
                mViewBinding.apply {
                    textViewNetworkStatus.text = resources.getString(R.string.text_no_connectivity)
                    networkStatusLayout.apply {
                        visibility = View.VISIBLE
                        setBackgroundColor(
                            ContextCompat.getColor(
                                this@MainActivity,
                                R.color.colorStatusNotConnected
                            )
                        )
                    }
                }
            } else {
                if (mViewModel.moviesLiveData.value is State.Error || mRvAdapter.itemCount == 0) {
                    getMovies()
                }

                mViewBinding.apply {
                    textViewNetworkStatus.text =
                        resources.getString(R.string.text_back_connectivity)

                    networkStatusLayout.apply {
                        setBackgroundColor(
                            ContextCompat.getColor(
                                this@MainActivity,
                                R.color.colorStatusConnected
                            )
                        )

                        animate().apply {
                            alpha(1f)
                            startDelay = 1000
                            duration = 1000
                            setListener(object : AnimatorListenerAdapter() {
                                override fun onAnimationEnd(animation: Animator?) {
                                    visibility = View.GONE
                                }
                            })
                        }
                    }
                }
            }
        })
    }

    private fun initView() {
        mViewBinding.mainMoviesRv.adapter = mRvAdapter
    }

    private fun initMovies() {
        mViewModel.moviesLiveData.observe(this, Observer { state ->
            when (state) {
                is State.Loading -> {
                    showLoading(true)
                }
                is State.Success -> {
                    mRvAdapter.submitList(state.data)
                    showLoading(false)
                }
                is State.Error -> {
                    Toast.makeText(this, state.message, Toast.LENGTH_SHORT).show()
                    showLoading(false)
                }
            }
        })

        if (mViewModel.moviesLiveData.value !is State.Success) {
            getMovies()
        }
    }

    private fun showLoading(b: Boolean) {
        mViewBinding.mainProgressBar.visibility = if (b) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

    private fun getMovies() {
        mViewModel.getMovies()
    }

    override fun onItemClicked(movie: Movie) {
        Intent(this, DetailActivity::class.java).apply {
            putExtra(DetailActivity.MOVIE_ID, movie.id)
            startActivity(this)
        }
    }
}