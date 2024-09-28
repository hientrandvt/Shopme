package com.demo.shopme.ui.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.shopme.domain.common.Resource
import com.demo.shopme.domain.usecases.ProductUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by Tran The Hien on 28,September,2024
 */
@HiltViewModel
class HomeViewModel @Inject constructor(private val productUseCases: ProductUseCases) :
    ViewModel() {
    private val _state = mutableStateOf(HomeState())
    val state: State<HomeState> = _state

    init {
        getProductList()
    }

    private fun getProductList() {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                productUseCases.getProductList()
            }
            if (result is Resource.Success) {
                _state.value = state.value.copy(
                    productList = result.data ?: listOf()
                )
            }
            //TODO: handle api error
        }
    }
}