package com.slim.garland.ui.connection.password

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.slim.garland.dependency.Dependencies

class WiFiPasswordViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WiFiPasswordViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return WiFiPasswordViewModel(Dependencies.wifiManager) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}