package com.slim.garland.ui.connection.wifi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.slim.garland.App
import com.slim.garland.dependency.Dependencies

class WiFiScanningViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WiFiScanningViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return WiFiScanningViewModel(App.instance, Dependencies.wifiManager) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}