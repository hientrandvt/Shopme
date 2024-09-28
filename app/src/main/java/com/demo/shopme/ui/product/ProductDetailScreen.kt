package com.demo.shopme.ui.product

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

/**
 * Created by Tran The Hien on 28,September,2024
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(
    navController: NavHostController
) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            TopAppBar(title = { Text("Product Detail") })
        }
    }
}