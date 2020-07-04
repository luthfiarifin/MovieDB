package com.laam.moviedb.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.laam.moviedb.R
import com.laam.moviedb.databinding.ActivityMainBinding
import com.laam.moviedb.ui.base.BaseActivity

/**
 * Created by luthfiarifin on 7/4/2020.
 */
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override fun getViewModel(): Class<MainViewModel> = MainViewModel::class.java

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}