package com.demo.shopme.data.entities.product

import com.google.gson.annotations.SerializedName

/**
 * Created by Tran The Hien on 27,September,2024
 */
class ProductData(
    @SerializedName("name")
    var name: String? = null,

    @SerializedName("price")
    var price: Int? = null,

    @SerializedName("content")
    var content: String? = null,

    @SerializedName("status")
    var status: String? = null,
)