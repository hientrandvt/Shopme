package com.demo.shopme.data.mappers

import com.demo.shopme.data.entities.product.ProductData
import com.demo.shopme.domain.model.product.ProductEntity

/**
 * Created by Tran The Hien on 27,September,2024
 */
fun Mapper.Companion.mapToEntity(productData: ProductData): ProductEntity {
    return ProductEntity(
        productId = productData.id,
        name = productData.name ?: "",
        price = productData.price,
        content = productData.content ?: "",
        status = productData.status ?: ""
    )
}