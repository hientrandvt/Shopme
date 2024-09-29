package com.demo.shopme.domain.repositories

import com.demo.shopme.domain.model.product.ProductEntity

/**
 * Created by Tran The Hien on 29,September,2024
 */
interface CartRepository {
    suspend fun getProductsInCart(): List<ProductEntity>

    suspend fun addProductToCart(product: ProductEntity)
}