package com.slim.garland.ui.connection.scanner

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.slim.garland.App
import com.slim.garland.dependency.Dependencies

class BluetoothScannerViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DeviceScannerViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DeviceScannerViewModel(
                App.instance,
                Dependencies.bluetoothAdapter
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}