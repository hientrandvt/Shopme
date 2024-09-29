package com.demo.shopme.di

import com.demo.shopme.data.db.CartDao
import com.demo.shopme.data.repositories.dataSourceImpl.CartRepositoryImpl
import com.demo.shopme.domain.repositories.CartRepository
import com.demo.shopme.domain.usecases.CartUseCases
import com.demo.shopme.domain.usecases.cart.AddProductToCart
import com.demo.shopme.domain.usecases.cart.GetProductsInCart
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Tran The Hien on 29,September,2024
 */
@Module
@InstallIn(SingletonComponent::class)
object CartModule {
    @Singleton
    @Provides
    fun provideCartRepository(cartDao: CartDao): CartRepository {
        return CartRepositoryImpl(cartDao)
    }

    @Singleton
    @Provides
    fun provideCartUseCases(cartRepository: CartRepository): CartUseCases {
        return CartUseCases(
            getProductsInCart = GetProductsInCart(cartRepository),
            addProductToCart = AddProductToCart(cartRepository)
        )
    }
}