package com.demo.shopme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.demo.shopme.domain.usecases.ProductUseCases
import com.demo.shopme.ui.navigation.ShopmeNavGraph
import com.demo.shopme.ui.theme.ShopmeTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShopmeTheme {
                val navController = rememberNavController()
                ShopmeNavGraph(
                    navController = navController
                )
            }

        }
    }
}