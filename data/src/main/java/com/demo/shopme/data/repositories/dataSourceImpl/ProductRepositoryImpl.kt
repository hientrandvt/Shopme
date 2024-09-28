package com.demo.shopme.data.repositories.dataSourceImpl

import com.demo.shopme.data.api.ApiProductService
import com.demo.shopme.data.mappers.Mapper
import com.demo.shopme.data.mappers.mapToEntity
import com.demo.shopme.data.utils.Utils
import com.demo.shopme.domain.common.Resource
import com.demo.shopme.domain.model.product.ProductEntity
import com.demo.shopme.domain.repositories.ProductRepository
import javax.inject.Inject

/**
 * Created by Tran The Hien on 27,September,2024
 */
//@Inject
class ProductRepositoryImpl @Inject constructor(private val apiService: ApiProductService) :
    ProductRepository {
    override suspend fun getProductList(): Resource<List<ProductEntity>> {
        val response = apiService.getProducts()
        val result = Utils.handleResponse(response)
        if (result is Resource.Error) {
            return Resource.Error(result.code, result.message)
        }

        val entities = result.data?.items?.map { productData ->
            Mapper.mapToEntity(
                productData
            )
        } ?: listOf()
        return Resource.Success(entities)
    }
}