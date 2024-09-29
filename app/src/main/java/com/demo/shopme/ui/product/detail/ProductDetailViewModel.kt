package com.demo.shopme.ui.product.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.shopme.domain.common.Resource
import com.demo.shopme.domain.usecases.CartUseCases
import com.demo.shopme.domain.usecases.ProductUseCases
import com.demo.shopme.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by Tran The Hien on 29,September,2024
 */
@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val productUseCases: ProductUseCases,
    private val cartUseCases: CartUseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val productId: Int =
        checkNotNull(savedStateHandle.get<String>(Constants.Screen.ProductDetail.productIdKey)).toInt()
    private val _state = mutableStateOf(ProductDetailState())
    val state: State<ProductDetailState> = _state

    init {
        getProductDetail(productId)
    }

    private fun getProductDetail(productId: Int) {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                productUseCases.getProductDetail(productId)
            }
            if (result is Resource.Success) {
                val productData = result.data
                val productStatus = productData?.status ?: ""
                val addableToCart =
                    productStatus.equals(Constants.ProductStatus.AVAILABLE.statusName)

                _state.value = state.value.copy(
                    productDetail = productData,
                    productStatus = Constants.ProductStatus.fromStatusName(
                        productStatus
                    ),
                    isAddableToCart = addableToCart,
                    cartBackgroundColor = if (addableToCart) Color.Blue else Color.Gray
                )
            }
            //TODO: handle api error
        }
    }

    fun addProductToCart(onProductAdded: () -> Unit) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                state.value.productDetail?.let {
                    cartUseCases.addProductToCart(it)
                }
            }
            onProductAdded()
        }
    }
}