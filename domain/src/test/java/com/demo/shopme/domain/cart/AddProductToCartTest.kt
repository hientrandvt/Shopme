package com.demo.shopme.domain.cart

/**
 * Created by Tran The Hien on 30,September,2024
 */
import com.demo.shopme.domain.models.product.ProductEntity
import com.demo.shopme.domain.repositories.CartRepository
import com.demo.shopme.domain.usecases.cart.AddProductToCart
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class AddProductToCartTest {

    private lateinit var cartRepository: CartRepository
    private lateinit var addProductToCart: AddProductToCart

    @Before
    fun setUp() {
        cartRepository = mock(CartRepository::class.java)
        addProductToCart = AddProductToCart(cartRepository)
    }

    @Test
    fun `test adding product to cart`() = runBlocking {
        val product = ProductEntity(productId = 100, name = "Test Product", price = 1000)

        addProductToCart(product)

        verify(cartRepository).addProductToCart(product)
    }
}
