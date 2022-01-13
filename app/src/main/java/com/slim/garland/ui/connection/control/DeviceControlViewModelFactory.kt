package com.slim.garland.ui.connection.control

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.slim.garland.dependency.Dependencies

class DeviceControlViewModelFactory(private val deviceAddress: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DeviceControlViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DeviceControlViewModel(Dependencies.bleControlManager, deviceAddress) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}