package com.demo.shopme.utils

/**
 * Created by Tran The Hien on 28,September,2024
 */
class Constants {

    sealed class Screen(val route: String) {
        object Home : Screen("Home")

        object ProductDetail : Screen("products/{productId}") {
            const val productId = "productId"
            fun createRoute(productId: String) = route.replace("{${productId}}", productId)
        }
    }
}