package com.demo.shopme.ui.product.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.demo.shopme.domain.model.product.ProductEntity
import com.demo.shopme.utils.Constants

/**
 * Created by Tran The Hien on 28, September, 2024
 */
@Composable
fun ProductItem(product: ProductEntity, onClick: () -> Unit, isFromCartScreen: Boolean = false) {
    val cardModifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
    val cardBackgroundColor =
        if (isFromCartScreen) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.surface
    val clickableModifier =
        if (isFromCartScreen) cardModifier else cardModifier.clickable(onClick = onClick)

    Card(
        modifier = clickableModifier,
        colors = CardDefaults.cardColors(containerColor = cardBackgroundColor),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = product.name ?: "",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(text = product.content ?: "", style = MaterialTheme.typography.bodyMedium)
                Text(
                    text = "${product.price} $",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
                if (!isFromCartScreen) {
                    val productStatus = Constants.ProductStatus.fromStatusName(product.status ?: "")
                    Text(
                        text = productStatus.statusText,
                        color = Color.White,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier
                            .background(productStatus.statusColor)
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
            }
        }
    }
}
