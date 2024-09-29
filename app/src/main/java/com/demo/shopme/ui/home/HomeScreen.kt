package com.demo.shopme.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.demo.shopme.R
import com.demo.shopme.ui.home.views.ProductItem
import com.demo.shopme.utils.Constants

/**
 * Created by Tran The Hien on 28,September,2024
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(), navController: NavHostController
) {
    val state = viewModel.state.value
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column {
                TopAppBar(title = { Text("Product List") })
                LazyColumn {
                    items(state.productList) { product ->
                        ProductItem(product = product, onClick = {
                            product.productId?.let {
                                navController.navigate(
                                    Constants.Screen.ProductDetail.createRoute(
                                        it
                                    )
                                )
                            }
                        })
                    }
                }
            }

            IconButton(
                onClick = {}, modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .size(80.dp)
            ) {
                Surface(
                    shape = CircleShape,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_cart),
                        contentDescription = "",
                        tint = Color.White,
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }

        }
    }

}