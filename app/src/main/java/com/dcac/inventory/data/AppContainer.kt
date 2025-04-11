package com.dcac.inventory.data

import android.content.Context

//App container for dependency injection
interface AppContainer {
    val itemsRepository: ItemsRepository
}

//AppContainer implementation that provides instance of OfflineItemsRepository
class AppDataContainer(private val context: Context) : AppContainer {

    //Implementation of ItemsRepository
    override val itemsRepository: ItemsRepository by lazy {
        OfflineItemsRepository()
    }
}