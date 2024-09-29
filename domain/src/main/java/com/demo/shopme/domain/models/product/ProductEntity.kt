package com.demo.shopme.domain.model.product

/**
 * Created by Tran The Hien on 27,September,2024
 */
data class ProductEntity(
    var productId: Int? = null,

    var name: String = "",

    var price: Int? = null,

    var content: String = "",

    var status: String = "",
)