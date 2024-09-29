package com.demo.shopme.data.repositories.dataSourceImpl

import com.demo.shopme.data.db.CartDao
import com.demo.shopme.data.mappers.Mapper
import com.demo.shopme.data.mappers.mapToData
import com.demo.shopme.data.mappers.mapToEntity
import com.demo.shopme.domain.model.product.ProductEntity
import com.demo.shopme.domain.repositories.CartRepository
import javax.inject.Inject

/**
 * Created by Tran The Hien on 29,September,2024
 */
class CartRepositoryImpl @Inject constructor(private val cartDao: CartDao) : CartRepository {
    override suspend fun getProductsInCart(): List<ProductEntity> {
        return cartDao.getProductsInCart().map {
            Mapper.mapToEntity(it)
        }
    }

    override suspend fun addProductToCart(product: ProductEntity) {
        cartDao.addProductToCart(Mapper.mapToData(product))
    }
}