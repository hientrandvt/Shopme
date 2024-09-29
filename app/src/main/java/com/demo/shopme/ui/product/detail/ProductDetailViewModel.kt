package com.demo.shopme.ui.product.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.shopme.domain.common.Resource
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
    private val productUseCases: ProductUseCases, savedStateHandle: SavedStateHandle
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
                _state.value = state.value.copy(
                    productDetail = result.data
                )
            }
            //TODO: handle api error
        }
    }
}