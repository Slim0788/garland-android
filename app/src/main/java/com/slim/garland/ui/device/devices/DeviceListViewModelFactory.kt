package com.slim.garland.ui.device.devices

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.slim.garland.App
import com.slim.garland.dependency.Dependencies

class DeviceListViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DeviceListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DeviceListViewModel(App.instance, Dependencies.wifiManager) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}