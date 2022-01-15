package com.slim.garland.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.color.DynamicColors
import com.slim.garland.R

// https://habr.com/ru/post/406559/     Часть 1
// https://habr.com/ru/post/407485/     Часть 2
// https://habr.com/ru/post/409107/     Часть 3 (Android)
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var navController: NavController

    companion object {
        var direction: Byte = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        WindowCompat.setDecorFitsSystemWindows(window, false)

        DynamicColors.applyIfAvailable(this)

        initView()
    }

    private fun initView() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
    }

}