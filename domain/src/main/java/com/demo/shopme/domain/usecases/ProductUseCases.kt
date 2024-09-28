package com.demo.shopme.domain.usecases

import com.demo.shopme.domain.usecases.product.GetProductDetail
import com.demo.shopme.domain.usecases.product.GetProductList

/**
 * Created by Tran The Hien on 27,September,2024
 */
data class ProductUseCases(
    val getProductList: GetProductList,
    val getProductDetail: GetProductDetail,
)