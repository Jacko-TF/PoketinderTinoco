package com.tinoco.jacko.poketinder.ui.view

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.tinoco.jacko.poketinder.databinding.ActivityMainBinding
import com.tinoco.jacko.poketinder.ui.viewmodel.MainViewModel
import com.tinoco.jacko.poketinder.R

class MainActivity : BaseActivity<ActivityMainBinding>
    (ActivityMainBinding::inflate){

    private val viewModel by lazy { MainViewModel() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment)

        navView.setupWithNavController(navController)
    }
}

