package com.dcac.inventory.ui

import android.app.Application
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory

import com.dcac.inventory.InventoryApplication
import com.dcac.inventory.ui.home.HomeViewModel
import com.dcac.inventory.ui.item.ItemDetailsViewModel
import com.dcac.inventory.ui.item.ItemEditViewModel
import com.dcac.inventory.ui.item.ItemEntryViewModel

// Provides Factory to create instance of ViewModel for the entire Inventory app
object AppViewModelProvider {
    val Factory = viewModelFactory {
        // Initializer for ItemEditViewModel
        initializer {
            ItemEditViewModel(
                this.createSavedStateHandle()
            )
        }
        // Initializer for ItemEntryViewModel
        initializer {
            ItemEntryViewModel()
        }

        // Initializer for ItemDetailsViewModel
        initializer {
            ItemDetailsViewModel(
                this.createSavedStateHandle()
            )
        }

        // Initializer for HomeViewModel
        initializer {
            HomeViewModel()
        }
    }
}

// Extension function to queries for [Application] object and returns an instance of
// InventoryApplication
fun CreationExtras.inventoryApplication(): InventoryApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as InventoryApplication)