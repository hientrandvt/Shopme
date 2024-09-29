package com.demo.shopme.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.demo.shopme.ui.cart.CartScreen
import com.demo.shopme.ui.home.HomeScreen
import com.demo.shopme.ui.product.detail.ProductDetailScreen
import com.demo.shopme.utils.Constants

/**
 * Created by Tran The Hien on 28,September,2024
 */
@Composable
fun ShopmeNavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Constants.Screen.Home.route) {
        composable(Constants.Screen.Home.route) { HomeScreen(navController = navController) }
        composable(
            route = Constants.Screen.ProductDetail.route,
            arguments = listOf(
                navArgument(Constants.Screen.ProductDetail.productIdKey) {
                    type = NavType.StringType
                },
            ),
        ) {
            ProductDetailScreen(navController = navController)
        }
        composable(Constants.Screen.Cart.route) { CartScreen(navController = navController) }
    }
}