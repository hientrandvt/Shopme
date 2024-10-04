package com.demo.shopme.ui.product.detail

import androidx.compose.ui.graphics.Color
import com.demo.shopme.domain.models.product.ProductEntity
import com.demo.shopme.utils.Constants

/**
 * Created by Tran The Hien on 29,September,2024
 */
data class ProductDetailState(
    val productDetail: ProductEntity? = null,
    val productStatus: Constants.ProductStatus = Constants.ProductStatus.UNKNOWN,
    val isAddableToCart: Boolean = false,
    val cartBackgroundColor: Color = Color.Gray
)