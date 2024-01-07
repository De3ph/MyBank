package com.example.mybank.presentation.component.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.mybank.constant.AvailableCurrencies
import com.example.mybank.constant.Dimensions


@Composable
fun AccountCard(
    name: String,
    iban: String,
    balance: Double,
    currencyType: AvailableCurrencies
) {

    Card(
        modifier = Modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        shape = MaterialTheme.shapes.small
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = Dimensions.Padding.lg, vertical = Dimensions.Padding.sm),
            verticalArrangement = Arrangement.spacedBy(Dimensions.Spacing.sm)
        ) {
            Text(text = name, style = MaterialTheme.typography.headlineSmall)
            Text(
                text = iban,
                style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.typography.labelSmall.color)
            )
            Text(
                text = "${currencyType.symbol} $balance",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }

}