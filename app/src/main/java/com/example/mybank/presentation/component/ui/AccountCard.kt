package com.example.mybank.presentation.component.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.mybank.constant.AvailableCurrencies
import com.example.mybank.constant.Dimensions


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AccountCard(
    name: String,
    iban: String,
    balance: Double,
    currencyType: AvailableCurrencies
) {

    ElevatedCard(
        modifier = Modifier.fillMaxWidth(0.9f),
        shape = MaterialTheme.shapes.small,
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = Dimensions.Padding.md, vertical = Dimensions.Padding.md),
            verticalArrangement = Arrangement.spacedBy(Dimensions.Spacing.sm)
        ) {
            Text(
                modifier = Modifier.basicMarquee(),
                text = name,
                style = MaterialTheme.typography.titleMedium
            )
//            Text(
//                text = iban,
//                style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.typography.labelSmall.color)
//            )
            Row(
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = "${currencyType.symbol} ",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.SemiBold
                    )
                )
                Text(
                    text = balance.toString(),
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.SemiBold
                    )
                )
            }


        }
    }

}