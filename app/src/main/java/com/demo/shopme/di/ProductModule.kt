package com.demo.shopme.di

import com.demo.shopme.data.api.ApiProductService
import com.demo.shopme.data.repositories.dataSourceImpl.ProductRepositoryImpl
import com.demo.shopme.domain.repositories.ProductRepository
import com.demo.shopme.domain.usecases.ProductUseCases
import com.demo.shopme.domain.usecases.product.GetProductDetail
import com.demo.shopme.domain.usecases.product.GetProductList
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Tran The Hien on 27,September,2024
 */
@Module
@InstallIn(SingletonComponent::class)
object ProductModule {
    @Singleton
    @Provides
    fun provideProductRepository(
        apiProductService: ApiProductService,
    ): ProductRepository {
        return ProductRepositoryImpl(apiProductService)
    }

    @Singleton
    @Provides
    fun provideProductUseCases(
        repository: ProductRepository,
    ): ProductUseCases {
        return ProductUseCases(
            getProductList = GetProductList(repository),
            getProductDetail = GetProductDetail(repository)
        )
    }
}