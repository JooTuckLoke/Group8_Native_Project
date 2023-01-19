package com.example.groupproject.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import java.util.concurrent.Executors

@Database(entities = [(Inventory::class)], version = 1)
abstract class InventoryRoomDatabase: RoomDatabase() {

    abstract fun inventoryDao(): InventoryDao

    companion object {

        private var INSTANCE: InventoryRoomDatabase? = null

        fun getInstance(context: Context): InventoryRoomDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        InventoryRoomDatabase::class.java,
                        "inventory_database"
                    ).fallbackToDestructiveMigration()
                        .addCallback(PopulateDbCallback(context))
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }

    class PopulateDbCallback(private val context: Context) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            val requestExecutor = Executors.newSingleThreadExecutor()
            requestExecutor.execute {
                val inventoryDao = InventoryRoomDatabase.getInstance(context).inventoryDao()
                val inventories = listOf(
                    Inventory("Stereo Amplifier", "Good", "389m away", "Audio", "RM 500", null, null, "Developer & Pet Lover", "product desc", "2020", "012345678"),
                    Inventory("Perfume", "Poor", "412m away", "Beauty & Personal Care", "RM 35", null, null, "Developer & Pet Lover", "product desc", "2023", "012345678"),
                    Inventory("Pot", "Average", "879m away", "Furniture & Home Living", "RM 250", null, null, "Developer & Pet Lover", "product desc", "2021", "012345678"),
                    Inventory("Polo Hat", "Good", "672m away", "Men's fashion", "RM 15", null, null, "Developer & Pet Lover", "product desc", "2022", "012345678"),
                    Inventory("Laptop Mantap", "Perfect", "982m away", "Computers & Tech", "RM2500", null, null, "Developer & Pet Lover", "product desc", "2021", "012345678")
                )
                inventoryDao.insertAllInventories(inventories)
            }
        }
    }
}
