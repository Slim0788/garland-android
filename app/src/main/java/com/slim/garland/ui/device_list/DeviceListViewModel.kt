package com.slim.garland.ui.device_list

import android.annotation.SuppressLint
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.slim.garland.data.SavedDevices
import com.slim.garland.utils.SingleEventLiveData

class DeviceListViewModel(application: Application) : AndroidViewModel(application) {

    @SuppressLint("StaticFieldLeak")
    private val context = getApplication<Application>().applicationContext

    private val _deviceList = MutableLiveData<List<DeviceEntity>>(SavedDevices.getDevices())
    val deviceList: LiveData<List<DeviceEntity>> = _deviceList

    private val _scannerWarning = SingleEventLiveData<String>()
    val scannerWarning: LiveData<String> = _scannerWarning

    private val _message = SingleEventLiveData<String>()
    val message: LiveData<String> = _message


}