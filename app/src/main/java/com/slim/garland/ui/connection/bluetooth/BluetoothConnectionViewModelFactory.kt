package com.slim.garland.ui.connection.bluetooth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.slim.garland.dependency.Dependencies

class BluetoothConnectionViewModelFactory(private val deviceAddress: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BluetoothConnectionViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return BluetoothConnectionViewModel(Dependencies.bleControlManager, deviceAddress) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}