package com.dcac.inventory.ui.home

import androidx.lifecycle.ViewModel
import com.dcac.inventory.model.Item

// ViewModel to retrieve all items in the Room database.
class HomeViewModel : ViewModel() {
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

// Ui State for HomeScreen
data class HomeUiState(val itemList: List<Item> = listOf())