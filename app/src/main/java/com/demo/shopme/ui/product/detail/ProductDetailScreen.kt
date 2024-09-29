package com.demo.shopme.ui.product.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

/**
 * Created by Tran The Hien on 28,September,2024
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(
    viewModel: ProductDetailViewModel = hiltViewModel(),
    navController: NavHostController
) {
    val state = viewModel.state.value
    val productDetail = state.productDetail
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            TopAppBar(title = { Text("Product Detail") })

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
                    text = productDetail?.price.toString(),
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    text = productDetail?.status ?: "",
                    style = MaterialTheme.typography.headlineSmall
                )

                Button(
                    onClick = {
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(text = "Add to Cart")
                }
            }
        }
    }
}