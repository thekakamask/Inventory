package com.dcac.inventory

import android.app.Application
import com.dcac.inventory.data.AppContainer
import com.dcac.inventory.data.AppDataContainer

class InventoryApplication : Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}