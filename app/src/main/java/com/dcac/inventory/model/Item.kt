package com.dcac.inventory.model

// Entity data class represents a single row in database
class Item(
    val id: Int = 0,
    val name: String,
    val price: Double,
    val quantity: Int
)