package com.demo.shopme.ui.cart

import com.demo.shopme.domain.model.product.ProductEntity

/**
 * Created by Tran The Hien on 29,September,2024
 */
data class CartState(val productList: List<ProductEntity> = listOf())