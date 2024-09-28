package com.demo.shopme.domain.usecases.product

import com.demo.shopme.domain.common.Resource
import com.demo.shopme.domain.model.product.ProductEntity
import com.demo.shopme.domain.repositories.ProductRepository

/**
 * Created by Tran The Hien on 28,September,2024
 */
class GetProductDetail(private val repository: ProductRepository) {

    suspend operator fun invoke(productId: Int): Resource<ProductEntity?> {
        return repository.getProductDetail(productId)
    }
}