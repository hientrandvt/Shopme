package com.demo.shopme.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.demo.shopme.data.entities.product.ProductData

/**
 * Created by Tran The Hien on 29,September,2024
 */
@Dao
interface CartDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProductToCart(productData: ProductData)

    @Query("SELECT * FROM cart_products")
    fun getProductsInCart(): List<ProductData>
}