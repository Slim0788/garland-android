package com.slim.garland.ui.connection.password

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.slim.garland.dependency.Dependencies

class WifiPasswordViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WifiPasswordViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return WifiPasswordViewModel(Dependencies.wifiManager) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}