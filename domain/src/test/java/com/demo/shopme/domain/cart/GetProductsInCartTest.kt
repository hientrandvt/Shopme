package com.demo.shopme.domain.cart

/**
 * Created by Tran The Hien on 30,September,2024
 */

import com.demo.shopme.domain.model.product.ProductEntity
import com.demo.shopme.domain.repositories.CartRepository
import com.demo.shopme.domain.usecases.cart.GetProductsInCart
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

class GetProductsInCartTest {

    private lateinit var cartRepository: CartRepository
    private lateinit var getProductsInCart: GetProductsInCart

    @Before
    fun setUp() {
        cartRepository = mock(CartRepository::class.java)
        getProductsInCart = GetProductsInCart(cartRepository)
    }

    @Test
    fun `test getting products in cart`() = runBlocking {
        val mockProducts = listOf(
            ProductEntity(productId = 1, name = "Test Product 1", price = 50),
            ProductEntity(productId = 2, name = "Test Product 2", price = 100)
        )

        `when`(cartRepository.getProductsInCart()).thenReturn(mockProducts)

        val result = getProductsInCart()

        assertEquals(mockProducts, result)
    }
}
