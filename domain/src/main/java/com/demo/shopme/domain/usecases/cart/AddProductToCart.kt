package com.demo.shopme.domain.usecases.cart

import com.demo.shopme.domain.model.product.ProductEntity
import com.demo.shopme.domain.repositories.CartRepository

/**
 * Created by Tran The Hien on 29,September,2024
 */
class AddProductToCart(private val repository: CartRepository) {
    suspend operator fun invoke(product: ProductEntity) {
        return repository.addProductToCart(product)
    }
}