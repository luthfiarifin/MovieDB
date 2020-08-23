package com.laam.movies.ui

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.laam.abstraction.base.BaseActivity
import com.laam.abstraction.util.network.NetworkUtils
import com.laam.abstraction.util.state.State
import com.laam.data.database.entity.Movie
import com.laam.movies.R
import com.laam.movies.databinding.FragmentMovieBinding
import com.laam.movies.ui.adapter.MovieListAdapter

/**
 * Created by luthfiarifin on 8/23/2020.
 */
class MovieFragment : BaseActivity<FragmentMovieBinding, MovieViewModel>(),
    MovieListAdapter.OnItemClickListener {

    private val mRvAdapter by lazy { MovieListAdapter(this) }

    override fun getViewModel(): Class<MovieViewModel> = MovieViewModel::class.java

    override fun getLayoutId(): Int = R.layout.fragment_movie

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
                                this@MovieFragment,
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
                                this@MovieFragment,
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

    }
}