package com.demo.shopme.utils

/**
 * Created by Tran The Hien on 28,September,2024
 */
class Constants {

    sealed class Screen(val route: String) {
        object Home : Screen("Home")

        object ProductDetail : Screen("productDetail/{productId}") {
            const val productIdKey = "productId"
            fun createRoute(productId: Int) =
                route.replace("{${productIdKey}}", productId.toString())
        }
    }
}