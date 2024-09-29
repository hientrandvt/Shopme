package com.demo.shopme.utils

import android.text.TextUtils
import androidx.compose.ui.graphics.Color

/**
 * Created by Tran The Hien on 28,September,2024
 */
class Constants {
    enum class ProductStatus(
        val statusName: String,
        val statusText: String,
        val statusColor: Color
    ) {
        OUT_OF_STOCK("out-of-stock", "Out of Stock", Color.Red),
        COMING_SOON("coming-soon", "Coming Soon", Color.Blue),
        AVAILABLE("available", "Available", Color.Green),
        UNKNOWN("unknown", "Unknown", Color.Gray);

        companion object {
            fun fromStatusName(statusName: String): ProductStatus {
                return entries.firstOrNull { TextUtils.equals(it.statusName, statusName) }
                    ?: UNKNOWN
            }
        }
    }


    sealed class Screen(val route: String) {
        object Home : Screen("Home")

        object ProductDetail : Screen("productDetail/{productId}") {
            const val productIdKey = "productId"
            fun createRoute(productId: Int) =
                route.replace("{${productIdKey}}", productId.toString())
        }

        object Cart : Screen("Cart")
    }
}