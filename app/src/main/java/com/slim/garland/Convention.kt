package com.slim.garland

import android.os.ParcelUuid

object Convention {

    val SERVICE_REGISTRATION_UUID: ParcelUuid =
        ParcelUuid.fromString("459aa3b5-52c3-4d75-a64b-9cd76f65cfbb")

    val SERVICE_WORK_TIME_UUID: ParcelUuid =
        ParcelUuid.fromString("cafa0333-8a16-4a59-b706-2f0e3fd38f58")
    val CHARACTERISTIC_REGISTRATION_CREDENTIALS_UUID: ParcelUuid =
        ParcelUuid.fromString("b9e70f80-d55e-4cd7-bec6-14be34590efc")
    val CHARACTERISTIC_REGISTRATION_RESPONSE_UUID: ParcelUuid =
        ParcelUuid.fromString("7048479a-23f2-4f5b-8113-e60e59294b5a")

    val CHARACTERISTIC_WORK_TIME_UUID: ParcelUuid =
        ParcelUuid.fromString("2c1529cd-f45d-4739-9738-2886fe46f7f1")
}