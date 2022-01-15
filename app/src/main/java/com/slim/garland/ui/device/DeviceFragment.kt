package com.slim.garland.ui.device

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationBarView
import com.slim.garland.R
import com.slim.garland.databinding.FragmentDeviceBinding

class DeviceFragment : Fragment(R.layout.fragment_device) {

    private var _binding: FragmentDeviceBinding? = null
    private val binding get() = _binding!!

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView(view)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initView(view: View) {
        _binding = FragmentDeviceBinding.bind(view)

        val localNavHostFragment =
            childFragmentManager.findFragmentById(R.id.local_nav_host_fragment) as NavHostFragment
        navController = localNavHostFragment.navController

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.deviceControlFragment,
                R.id.deviceEffectsFragment,
                R.id.deviceSettingsFragment
            )
        )

        NavigationUI.setupWithNavController(binding.requireNavigationView, navController)
        NavigationUI.setupWithNavController(binding.toolbar, navController, appBarConfiguration)

    }

    private val FragmentDeviceBinding.requireNavigationView: NavigationBarView
        get() = navigationView as NavigationBarView
}