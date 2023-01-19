package com.example.groupproject

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.example.groupproject.data.Inventory
import com.example.groupproject.data.InventoryRoomDatabase
import kotlinx.coroutines.flow.Flow

class InventoryViewModel(application: Application) : AndroidViewModel(application) {
    val db = Room.databaseBuilder(application, InventoryRoomDatabase::class.java, "inventory_database.db").build()

    fun insert(inventory: Inventory) {
        db.inventoryDao().insertInventory(inventory)
    }

    fun update(name: String) {
        db.inventoryDao().findInventory(name)
    }

    fun delete(name: String) {
        db.inventoryDao().deleteInventory(name)
    }

    fun getAll(): LiveData<List<Inventory>> {
        return db.inventoryDao().getAllInventories()
    }

    fun getById(name: String) : List<Inventory>{
        return db.inventoryDao().findInventory(name)
    }
}
