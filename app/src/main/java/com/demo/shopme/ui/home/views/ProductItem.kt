package com.demo.shopme.ui.home.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.demo.shopme.domain.model.product.ProductEntity

/**
 * Created by Tran The Hien on 28, September, 2024
 */
@Composable
fun ProductItem(product: ProductEntity, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = product.name,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(text = product.content, style = MaterialTheme.typography.bodyMedium)
                Text(text = product.price.toString(), style = MaterialTheme.typography.bodyMedium)
                Text(text = product.status, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}
