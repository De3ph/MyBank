package com.example.mybank.presentation.component.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.mybank.constant.Dimensions

@Composable
fun RateListItem(
    name: String,
    rate: Double
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Dimensions.Spacing.md),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Column(
            Modifier.padding(Dimensions.Padding.sm)
        ) {
            Text(
                text = "$name", style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.SemiBold
                )
            )
        }
        Column(
            Modifier.padding(Dimensions.Padding.sm)
        ) {
            Text(
                text = "$rate", style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.SemiBold
                )
            )
        }
    }

}

