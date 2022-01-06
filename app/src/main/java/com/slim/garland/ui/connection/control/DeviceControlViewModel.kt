package com.slim.garland.ui.connection.control

import android.app.Application
import android.bluetooth.BluetoothAdapter
import androidx.lifecycle.AndroidViewModel

class DeviceControlViewModel(
    application: Application,
    private val bluetoothAdapter: BluetoothAdapter
) : AndroidViewModel(application) {


}