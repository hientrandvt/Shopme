package com.demo.shopme.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.demo.shopme.ui.common.AppNavigationBar
import com.demo.shopme.ui.home.views.CartButton
import com.demo.shopme.ui.home.views.ProductItem
import com.demo.shopme.utils.Constants

/**
 * Created by Tran The Hien on 28,September,2024
 */
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(), navController: NavHostController
) {
    val state = viewModel.state.value
    LaunchedEffect(navController.currentBackStackEntry) {
        viewModel.fetchProductsAndCartCount()
    }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column {
                AppNavigationBar(title = "Product List", showBackButton = false)
                LazyColumn {
                    items(state.productList) { product ->
                        ProductItem(product = product, onClick = {
                            navController.navigate(
                                Constants.Screen.ProductDetail.createRoute(
                                    product.productId
                                )
                            )
                        })
                    }
                }
            }

            CartButton(cartItemCount = state.cartItemCount, navController = navController)

        }
    }

}