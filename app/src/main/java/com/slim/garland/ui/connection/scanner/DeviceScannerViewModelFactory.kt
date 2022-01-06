package com.slim.garland.ui.connection.scanner

import android.app.Application
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DeviceScannerViewModelFactory(private val application: Application) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DeviceScannerViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DeviceScannerViewModel(
                application,
                createBluetoothAdapter()
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

    private fun createBluetoothAdapter(): BluetoothAdapter =
        (application.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager).adapter

}