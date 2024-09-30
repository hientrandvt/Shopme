package com.demo.shopme.ui.cart

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.demo.shopme.ui.cart.views.CartItem
import com.demo.shopme.ui.common.AppNavigationBar

/**
 * Created by Tran The Hien on 29,September,2024
 */
@Composable
fun CartScreen(viewModel: CartViewModel = hiltViewModel(), navController: NavHostController) {
    val state = viewModel.state.value
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            AppNavigationBar(title = "Cart", navController = navController)
            LazyColumn {
                items(state.productList) { product ->
                    CartItem(product = product)
                }
            }
        }

    }

}