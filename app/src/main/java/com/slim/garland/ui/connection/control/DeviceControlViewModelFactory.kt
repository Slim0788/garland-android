package com.slim.garland.ui.connection.control

import android.app.Application
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DeviceControlViewModelFactory(private val application: Application) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DeviceControlViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DeviceControlViewModel(
                application,
                createBluetoothAdapter()
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

    private fun createBluetoothAdapter(): BluetoothAdapter =
        (application.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager).adapter

}