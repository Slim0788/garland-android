package com.slim.garland.ui

import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import com.slim.garland.R

// https://habr.com/ru/post/406559/     Часть 1
// https://habr.com/ru/post/407485/     Часть 2
// https://habr.com/ru/post/409107/     Часть 3 (Android)
class RootActivity : AppCompatActivity(R.layout.activity_root) {

    val toolbar: MaterialToolbar by lazy { findViewById(R.id.toolbar) }

//    WindowCompat.setDecorFitsSystemWindows(window, false)
}