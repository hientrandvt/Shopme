package com.demo.shopme.data

/**
 * Created by Tran The Hien on 30,September,2024
 */
import com.demo.shopme.data.db.CartDao
import com.demo.shopme.data.entities.product.ProductData
import com.demo.shopme.data.mappers.Mapper
import com.demo.shopme.data.mappers.mapToData
import com.demo.shopme.data.repositories.dataSourceImpl.CartRepositoryImpl
import com.demo.shopme.domain.models.product.ProductEntity
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`

class CartRepositoryImplTest {

    private lateinit var cartDao: CartDao
    private lateinit var cartRepository: CartRepositoryImpl

    private val mockProductData = ProductData(
        product_id = 1,
        name = "Third Item",
        price = 190,
        content = "Some very very looong text to display as the product content blablabla",
        status = "coming-soon"
    )
    val mockProductEntity = ProductEntity(
        productId = 1,
        name = "Third Item",
        price = 190,
        content = "Some very very looong text to display as the product content blablabla",
        status = "coming-soon"
    )

    @Before
    fun setUp() {
        cartDao = mock(CartDao::class.java)
        cartRepository = CartRepositoryImpl(cartDao)
    }

    @Test
    fun testGetProductsInCart() = runBlocking {
        `when`(cartDao.getProductsInCart()).thenReturn(listOf(mockProductData))

        val result = cartRepository.getProductsInCart()

        assertEquals(1, result.size)
        assertEquals(
            mockProductEntity,
            result[0]
        )
    }

    @Test
    fun testAddProductToCart() = runBlocking {
        cartRepository.addProductToCart(mockProductEntity)
        verify(cartDao).addProductToCart(Mapper.mapToData(mockProductEntity))
    }
}
