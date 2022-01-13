package com.slim.garland.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.slim.garland.R
import com.slim.garland.ui.connection.scanner.DeviceScannerFragment

// https://habr.com/ru/post/406559/     Часть 1
// https://habr.com/ru/post/407485/     Часть 2
// https://habr.com/ru/post/409107/     Часть 3 (Android)
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    companion object {
        var direction: Byte = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        WindowCompat.setDecorFitsSystemWindows(window, false)

//        HttpClient(40000)
//        UdpClient()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, DeviceScannerFragment.newInstance())
                .commit()
        }

    }

}