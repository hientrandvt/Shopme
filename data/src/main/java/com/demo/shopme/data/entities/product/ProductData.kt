package com.demo.shopme.data.entities.product

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by Tran The Hien on 27,September,2024
 */
@Entity(tableName = "cart_products")
class ProductData(

    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = "product_id")
    var product_id: Int,

    @ColumnInfo(name = "name")
    var name: String? = null,

    @ColumnInfo(name = "price")
    var price: Int? = null,

    @ColumnInfo(name = "content")
    var content: String? = null,

    @ColumnInfo(name = "status")
    var status: String? = null,
)