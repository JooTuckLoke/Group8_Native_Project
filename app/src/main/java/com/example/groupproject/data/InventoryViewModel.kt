package com.example.groupproject.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InventoryViewModel(application: Application) : ViewModel() {

    val allInventories: LiveData<List<Inventory>>
    private val repository: InventoryRepository
    val searchResults: MutableLiveData<List<Inventory>>

    init {
        val inventoryDb = InventoryRoomDatabase.getInstance(application)
        val inventoryDao = inventoryDb.inventoryDao()
        repository = InventoryRepository(inventoryDao)

        allInventories = repository.allInventories
        searchResults = repository.searchResults
    }

    fun insertInventory(inventory: Inventory) {
        repository.insertInventory(inventory)
    }

    fun findInventory(name: String) {
        repository.findInventory(name)
    }

    fun deleteInventory(name: String) {
        repository.deleteInventory(name)
    }

}
