package com.slim.garland.data

import com.slim.garland.ui.device.devices.DeviceEntity

object SavedDevices {

    fun getDevices() = listOf(
        DeviceEntity(0, "Name 1"),
        DeviceEntity(1, "Name 2"),
        DeviceEntity(2, "Name 3"),
        DeviceEntity(3, "Name 4"),
        DeviceEntity(4, "Name 5"),
        DeviceEntity(5, "Name 6"),
        DeviceEntity(6, "Name 7"),
        DeviceEntity(7, "Name 8"),
    )
}