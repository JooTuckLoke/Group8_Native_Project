package com.example.groupproject.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface InventoryDao {
    @Insert
    fun insertInventory(inventory: Inventory)

    @Insert
    fun insertAllInventories(inventories: List<Inventory>)

    @Query("SELECT * FROM inventory WHERE productName = :name")
    fun findInventory(name: String): List<Inventory>

    @Query("DELETE FROM inventory WHERE productName = :name")
    fun deleteInventory(name: String)

    @Query("SELECT * FROM inventory")
    fun getAllInventories(): LiveData<List<Inventory>>


}
