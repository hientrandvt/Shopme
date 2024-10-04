package com.demo.shopme.domain.usecases.product

import com.demo.shopme.domain.common.Resource
import com.demo.shopme.domain.models.product.ProductEntity
import com.demo.shopme.domain.repositories.ProductRepository

/**
 * Created by Tran The Hien on 27,September,2024
 */
class GetProductList(private val repository: ProductRepository) {

    suspend operator fun invoke(): Resource<List<ProductEntity>> {
        return repository.getProductList()
    }
}