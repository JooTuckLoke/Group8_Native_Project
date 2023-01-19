package com.example.groupproject.data

import android.graphics.Bitmap
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "inventory")
class Inventory {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "inventoryId")
    var id: Int = 0

    @ColumnInfo(name = "productName")
    var productName: String = ""

    @ColumnInfo(name = "productCondition")
    var productCondition: String = ""

    @ColumnInfo(name = "location")
    var location: String = ""

    @ColumnInfo(name = "category")
    var category: String = ""

    @ColumnInfo(name = "price")
    var price: String = ""

    @ColumnInfo(name = "owner_description")
    var ownerDescription: String = ""

    @ColumnInfo(name = "product_description")
    var productDescription: String = ""

    @ColumnInfo(name = "bought_year")
    var boughtYear: String = ""

    @ColumnInfo(name = "contact_number")
    var contactNumber: String = ""

    constructor() {}

    constructor(productname: String, condition: String, location: String, category: String, price: String, productImg: Bitmap?, ownerImg: Bitmap?, ownerDescription: String, productDescription: String, boughtYear: String, contactNumber: String) {
        this.productName = productname
        this.productCondition = condition
        this.location = location
        this.category = category
        this.price = price
        this.ownerDescription = ownerDescription
        this.productDescription = productDescription
        this.boughtYear = boughtYear
        this.contactNumber = contactNumber
    }
}
