package com.demo.shopme.ui.home.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.demo.shopme.R
import com.demo.shopme.utils.Constants

/**
 * Created by Tran The Hien on 30,September,2024
 */

@Composable
fun CartButton(cartItemCount: Int, navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        IconButton(
            onClick = {
                navController.navigate(Constants.Screen.Cart.route)
            },
            modifier = Modifier
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
                    contentDescription = "Cart",
                    tint = Color.White,
                    modifier = Modifier.padding(10.dp)
                )
            }
        }

        if (cartItemCount > 0) {
            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .offset(x = (-10).dp, y = (-45).dp)
                    .size(24.dp)
                    .background(Color.Red, shape = CircleShape)
            ) {
                Text(
                    text = cartItemCount.toString(),
                    color = Color.White,
                    fontSize = 12.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}


