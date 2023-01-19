
package com.example.groupproject.model

data class Item(
    val id: Int,
    val name: String,
    val price: String,
    val category: String,
    val location: String,
    val image: Int,
    val about: String,
    val condition: String,
    val year: String,
    val owner: Owner
)
