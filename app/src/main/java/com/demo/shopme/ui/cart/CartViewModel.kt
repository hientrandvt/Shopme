package com.demo.shopme.ui.cart

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.shopme.domain.usecases.CartUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by Tran The Hien on 29,September,2024
 */
@HiltViewModel
class CartViewModel @Inject constructor(
    private val cartUseCases: CartUseCases
) : ViewModel() {
    private val _state = mutableStateOf(CartState())
    val state: State<CartState> = _state

    init {
        getProductsInCart()
    }

    private fun getProductsInCart() {
        viewModelScope.launch {
            val productList = withContext(Dispatchers.IO) {
                cartUseCases.getProductsInCart()
            }
            _state.value = state.value.copy(
                productList = productList
            )
        }
    }

}