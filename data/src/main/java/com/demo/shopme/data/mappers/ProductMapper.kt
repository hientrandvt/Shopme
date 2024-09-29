package com.demo.shopme.data.mappers

import com.demo.shopme.data.entities.product.ProductData
import com.demo.shopme.domain.model.product.ProductEntity

/**
 * Created by Tran The Hien on 27,September,2024
 */
fun Mapper.Companion.mapToEntity(productData: ProductData): ProductEntity {
    return ProductEntity(
        productId = productData.product_id,
        name = productData.name,
        price = productData.price,
        content = productData.content,
        status = productData.status
    )
}

fun Mapper.Companion.mapToData(productEntity: ProductEntity): ProductData {
    return ProductData(
        product_id = productEntity.productId,
        name = productEntity.name,
        price = productEntity.price,
        content = productEntity.content,
        status = productEntity.status
    )
}

