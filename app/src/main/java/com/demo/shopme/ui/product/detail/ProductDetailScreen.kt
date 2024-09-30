package com.demo.shopme.ui.product.detail

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.demo.shopme.ui.common.AppNavigationBar
import com.demo.shopme.utils.AppUtils

/**
 * Created by Tran The Hien on 28,September,2024
 */
@Composable
fun ProductDetailScreen(
    viewModel: ProductDetailViewModel = hiltViewModel(),
    navController: NavHostController
) {
    val context = LocalContext.current
    val state = viewModel.state.value
    val productDetail = state.productDetail
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            AppNavigationBar(title = "Product Detail", navController = navController)
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = productDetail?.name ?: "",
                    style = MaterialTheme.typography.headlineMedium
                )
                Text(
                    text = productDetail?.content ?: "",
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    text = "${productDetail?.price} $",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(vertical = 6.dp)
                )
                Text(
                    text = state.productStatus.statusText,
                    color = Color.White,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier
                        .background(state.productStatus.statusColor)
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                )

                Button(
                    onClick = {
                        if (state.isAddableToCart) {
                            viewModel.addProductToCart {
                                Toast.makeText(
                                    context,
                                    "Product added to cart successfully!",
                                    Toast.LENGTH_SHORT
                                ).show()
                                AppUtils.vibrate(context)
                                navController.popBackStack()
                            }
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = state.cartBackgroundColor)
                ) {
                    Text(
                        color = Color.White,
                        text = "Add to Cart",
                        style = MaterialTheme.typography.headlineSmall,
                    )
                }
            }
        }
    }
}