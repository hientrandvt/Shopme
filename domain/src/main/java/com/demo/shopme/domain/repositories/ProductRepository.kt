package com.demo.shopme.domain.repositories

import com.demo.shopme.domain.common.Resource
import com.demo.shopme.domain.model.product.ProductEntity

/**
 * Created by Tran The Hien on 27,September,2024
 */
interface ProductRepository {
    suspend fun getProductList(): Resource<List<ProductEntity>>
}