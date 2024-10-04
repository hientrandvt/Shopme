//package com.demo.shopme.viewmodel
//
///**
// * Created by Tran The Hien on 30,September,2024
// */
//
//import com.demo.shopme.domain.common.Resource
//import com.demo.shopme.domain.models.product.ProductEntity
//import com.demo.shopme.domain.repositories.ProductRepository
//import com.demo.shopme.domain.usecases.CartUseCases
//import com.demo.shopme.domain.usecases.ProductUseCases
//import com.demo.shopme.domain.usecases.product.GetProductDetail
//import com.demo.shopme.domain.usecases.product.GetProductList
//import com.demo.shopme.ui.home.HomeViewModel
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.ExperimentalCoroutinesApi
//import kotlinx.coroutines.test.StandardTestDispatcher
//import kotlinx.coroutines.test.resetMain
//import kotlinx.coroutines.test.runBlockingTest
//import kotlinx.coroutines.test.setMain
//import org.junit.After
//import org.junit.Assert.assertEquals
//import org.junit.Before
//import org.junit.Test
//import org.mockito.Mockito.mock
//import org.mockito.Mockito.`when`
//
//class HomeViewModelTest {
//
//
//    private lateinit var homeViewModel: HomeViewModel
//    private val productRepository: ProductRepository = mock()
//    private val getProductList: GetProductList = mock()
//    private val getProductDetail: GetProductDetail = mock()
//    private val cartUseCases: CartUseCases = mock()
//
//    private val productUseCases = ProductUseCases(
//        getProductList = getProductList,
//        getProductDetail = getProductDetail
//    )
//
//    private val testDispatcher = StandardTestDispatcher()
//
//    @OptIn(ExperimentalCoroutinesApi::class)
//    @Before
//    fun setUp() {
//        homeViewModel = HomeViewModel(productUseCases, cartUseCases)
//        Dispatchers.setMain(testDispatcher)
//    }
//
//    @Test
//    fun `getting product list should update state with product list`() =
//        runBlockingTest {
//
//            val mockProducts = listOf(ProductEntity(productId = 100, name = "Test product 1"))
//
//            println("Before calling getProductList, current product list: ${homeViewModel.state.value.productList}")
//
//            `when`(getProductList.invoke()).thenReturn(Resource.Success(mockProducts))
//
//
//            homeViewModel.getProductList()
//
//            println("After calling getProductList, current product list: ${homeViewModel.state.value}")
//
//            assertEquals(mockProducts, homeViewModel.state.value.productList)
//        }
//
//    @OptIn(ExperimentalCoroutinesApi::class)
//    @After
//    fun tearDown() {
//        Dispatchers.resetMain()
//    }
//
//}
