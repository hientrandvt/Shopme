package com.demo.shopme.data.api

import com.demo.shopme.data.api.response.BaseResponse
import com.demo.shopme.data.entities.product.ProductData
import com.demo.shopme.data.entities.product.ProductList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Tran The Hien on 27,September,2024
 */
interface ApiProductService {
    @GET("products")
    suspend fun getProducts(): Response<BaseResponse<ProductList?>>

    @GET("products/{productId}")
    suspend fun getProductDetail(@Path("productId") productId: Int): Response<BaseResponse<ProductData?>>
}