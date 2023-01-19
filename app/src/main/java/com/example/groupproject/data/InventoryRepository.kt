package com.example.groupproject.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

class InventoryRepository(private val inventoryDao: InventoryDao) {
    val allInventories: LiveData<List<Inventory>> = inventoryDao.getAllInventories()
    val searchResults = MutableLiveData<List<Inventory>>()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun insertInventory(newInventory: Inventory) {
        coroutineScope.launch(Dispatchers.IO) {
            inventoryDao.insertInventory(newInventory)
        }
    }

    fun deleteInventory(name: String) {
        coroutineScope.launch(Dispatchers.IO) {
            inventoryDao.deleteInventory(name)
        }
    }

    fun findInventory(name: String) {
        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncFind(name).await()
        }
    }

    private fun asyncFind(name: String): Deferred<List<Inventory>?> =
        coroutineScope.async(Dispatchers.IO) {
            return@async inventoryDao.findInventory(name)
        }
}
