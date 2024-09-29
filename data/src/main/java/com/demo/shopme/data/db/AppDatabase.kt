package com.demo.shopme.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.demo.shopme.data.entities.product.ProductData

/**
 * Created by Tran The Hien on 29,September,2024
 */
@Database(
    entities = [ProductData::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract val cartDao: CartDao

    companion object {
        const val DATABASE_NAME = "shopme_database"
    }
}