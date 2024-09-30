package com.demo.shopme.domain.product

/**
 * Created by Tran The Hien on 30,September,2024
 */

import com.demo.shopme.domain.common.Resource
import com.demo.shopme.domain.model.product.ProductEntity
import com.demo.shopme.domain.repositories.ProductRepository
import com.demo.shopme.domain.usecases.product.GetProductList
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class GetProductListTest {

    @Mock
    private lateinit var productRepository: ProductRepository

    private lateinit var getProductList: GetProductList

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        getProductList = GetProductList(productRepository)
    }

    @Test
    fun `test getting product list successfully`() = runBlocking {
        val mockProducts =
            listOf(ProductEntity(1, "Product 1", 100), ProductEntity(2, "Product 2", 200))

        `when`(productRepository.getProductList()).thenReturn(Resource.Success(mockProducts))

        val result = getProductList()

        assertEquals(Resource.Success(mockProducts).data?.size, result.data?.size)
    }

    @Test
    fun `test getting product list error`() = runBlocking {
        val error = Resource.Error<List<ProductEntity>>(
            code = "400",
            message = "Error when getting product list",
            data = null
        )
        `when`(productRepository.getProductList()).thenReturn(error)

        val result = getProductList()

        assertEquals(error, result)
    }
}
