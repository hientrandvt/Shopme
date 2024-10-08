package com.demo.shopme.ui.home

import com.demo.shopme.domain.models.product.ProductEntity

/**
 * Created by Tran The Hien on 28,September,2024
 */
data class HomeState(val productList: List<ProductEntity> = listOf(), val cartItemCount: Int = 0)