package com.demo.shopme.ui.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.demo.shopme.R

/**
 * Created by Tran The Hien on 30,September,2024
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigationBar(
    title: String,
    navController: NavController? = null,
    showBackButton: Boolean = true
) {
    TopAppBar(
        title = { Text(title) },
        navigationIcon = {
            if (showBackButton) {
                NavigationIcon(navController)
            }
        }
    )

    HorizontalDivider(
        modifier = Modifier
            .fillMaxWidth(),
        thickness = 0.5.dp,
        color = Color.LightGray
    )
}

@Composable
fun NavigationIcon(navController: NavController? = null) {
    IconButton(onClick = {
        navController?.popBackStack()
    }) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_arrow_back),
            contentDescription = "Back"
        )
    }
}
