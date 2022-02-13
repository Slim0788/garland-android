package com.slim.garland

import android.app.Application
import com.google.android.material.color.DynamicColors

class App : Application() {

    companion object {
        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        DynamicColors.applyToActivitiesIfAvailable(this)
        instance = this
    }

}