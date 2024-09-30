package com.demo.shopme.data

/**
 * Created by Tran The Hien on 30,September,2024
 */
import com.demo.shopme.data.api.ApiProductService
import com.demo.shopme.data.api.response.BaseResponse
import com.demo.shopme.data.entities.product.ProductData
import com.demo.shopme.data.entities.product.ProductList
import com.demo.shopme.data.repositories.dataSourceImpl.ProductRepositoryImpl
import com.demo.shopme.domain.common.Resource
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import retrofit2.Response

class ProductRepositoryImplTest {

    private lateinit var productRepository: ProductRepositoryImpl
    private val apiService: ApiProductService = mock(ApiProductService::class.java)


    private val mockProductData = ProductData(
        product_id = 1,
        name = "Third Item",
        price = 190,
        content = "Some very very looong text to display as the product content blablabla",
        status = "coming-soon"
    )

    // mock data for product list
    private val mockProductList = ProductList(
        items = listOf(mockProductData)
    )

    private val mockProductListResponseSuccess = BaseResponse<ProductList?>(
        result = 1, errorCode = "", errorMsg = "", data = mockProductList
    )

    private val mockProductListResponseError = BaseResponse<ProductList?>(
        result = 0, errorCode = "401", errorMsg = "Login require", data = mockProductList
    )

    private val mockProductListEmptyResponseSuccess = BaseResponse<ProductList?>(
        result = 1, errorCode = "", errorMsg = "", data = ProductList(
            items = listOf()
        )
    )

    @Before
    fun setUp() {
        productRepository = ProductRepositoryImpl(apiService)
    }

    @Test
    fun `getProductList should return success when API returns data`() = runTest {
        `when`(apiService.getProducts()).thenReturn(Response.success(mockProductListResponseSuccess))

        val result = productRepository.getProductList()

        assertTrue(result is Resource.Success)
        assertEquals((result as Resource.Success).data?.size, mockProductList.items.size)
    }

    @Test
    fun `getProductList should return error when API fails`() = runTest {
        `when`(apiService.getProducts()).thenReturn(Response.success(mockProductListResponseError))

        val result = productRepository.getProductList()

        assertTrue(result is Resource.Error)
        assertEquals(result.code, mockProductListResponseError.errorCode)
        assertEquals(result.message, mockProductListResponseError.errorMsg)
    }


    @Test
    fun `getProductList should return empty list when API returns no data`() = runTest {
        `when`(apiService.getProducts()).thenReturn(
            Response.success(
                mockProductListEmptyResponseSuccess
            )
        )

        val result = productRepository.getProductList()

        assertTrue(result is Resource.Success)
        assertEquals((result as Resource.Success).data?.size, 0)
    }


    // mock data for product detail
    private val mockProductDetailResponseSuccess = BaseResponse<ProductData?>(
        result = 1, errorCode = "", errorMsg = "", data = mockProductData
    )

    private val mockProductDetailResponseError = BaseResponse<ProductData?>(
        result = 0, errorCode = "400", errorMsg = "User not found", data = mockProductData
    )

    private val mockProductDetailEmptyResponseSuccess = BaseResponse<ProductData?>(
        result = 1, errorCode = "", errorMsg = "", data = null
    )

    @Test
    fun `getProductDetail should return success when API returns data`() = runTest {
        `when`(apiService.getProductDetail(1)).thenReturn(
            Response.success(
                mockProductDetailResponseSuccess
            )
        )

        val result = productRepository.getProductDetail(1)

        assertTrue(result is Resource.Success)
        assertEquals((result as Resource.Success).data?.productId, mockProductData.product_id)
    }

    @Test
    fun `getProductDetail should return error when API fails`() = runTest {
        `when`(apiService.getProductDetail(1)).thenReturn(
            Response.success(
                mockProductDetailResponseError
            )
        )

        val result = productRepository.getProductDetail(1)

        assertTrue(result is Resource.Error)
        assertEquals((result as Resource.Error).code, mockProductDetailResponseError.errorCode)
    }


    @Test
    fun `getProductDetail should return null when product is not found`() = runTest {
        `when`(apiService.getProductDetail(99)).thenReturn(
            Response.success(
                mockProductDetailEmptyResponseSuccess
            )
        )

        val result = productRepository.getProductDetail(99)

        assertTrue(result is Resource.Success)
        assertEquals((result as Resource.Success).data, null)
    }

}

