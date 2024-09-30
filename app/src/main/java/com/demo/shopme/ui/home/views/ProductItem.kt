package com.demo.shopme.ui.home.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.demo.shopme.R
import com.demo.shopme.domain.model.product.ProductEntity
import com.demo.shopme.utils.Constants

/**
 * Created by Tran The Hien on 28, September, 2024
 */
@Composable
fun ProductItem(product: ProductEntity, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 8.dp, bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
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

            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_arrow_right),
                contentDescription = "Arrow icon",
                tint = Color.Gray
            )
        }
    }
}
