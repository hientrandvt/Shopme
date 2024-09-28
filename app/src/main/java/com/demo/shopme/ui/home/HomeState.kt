package com.demo.shopme.ui.home

import com.demo.shopme.domain.model.product.ProductEntity

/**
 * Created by Tran The Hien on 28,September,2024
 */
data class HomeState(val productList: List<ProductEntity> = listOf())