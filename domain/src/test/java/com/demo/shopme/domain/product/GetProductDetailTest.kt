package com.demo.shopme.domain.product

/**
 * Created by Tran The Hien on 30,September,2024
 */

import com.demo.shopme.domain.common.Resource
import com.demo.shopme.domain.model.product.ProductEntity
import com.demo.shopme.domain.repositories.ProductRepository
import com.demo.shopme.domain.usecases.product.GetProductDetail
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class GetProductDetailTest {

    @Mock
    private lateinit var productRepository: ProductRepository

    private lateinit var getProductDetail: GetProductDetail

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        getProductDetail = GetProductDetail(productRepository)
    }

    @Test
    fun `test getting product detail successfully`() = runBlocking {
        val productId = 1
        val mockProduct = ProductEntity(productId, "Product 1", 100)
        `when`(productRepository.getProductDetail(productId)).thenReturn(
            Resource.Success(
                mockProduct
            )
        )

        val result = getProductDetail(productId)

        assertEquals(Resource.Success(mockProduct), result)
    }

    @Test
    fun `test getting product detail not found`() = runBlocking {
        val productId = 1
        `when`(productRepository.getProductDetail(productId)).thenReturn(Resource.Success(null))

        val result = getProductDetail(productId)

        assertEquals(Resource.Success<ProductEntity?>(null), result)
    }

    @Test
    fun `test getting product detail failure`() = runBlocking {
        val productId = 1
        val error = Resource.Error<ProductEntity?>(
            code = "400",
            message = "Error when getting product detail",
            data = null
        )
        `when`(productRepository.getProductDetail(productId)).thenReturn(error)

        val result = getProductDetail(productId)

        assertEquals(error, result)
    }
}
