package com.demo.shopme.domain.usecases

import com.demo.shopme.domain.usecases.cart.AddProductToCart
import com.demo.shopme.domain.usecases.cart.GetProductsInCart

/**
 * Created by Tran The Hien on 29,September,2024
 */
data class CartUseCases(
    val getProductsInCart: GetProductsInCart,
    val addProductToCart: AddProductToCart
)