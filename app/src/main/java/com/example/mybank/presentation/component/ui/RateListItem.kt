package com.example.mybank.presentation.component.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.mybank.constant.Dimensions

@Composable
fun RateListItem(
    name: String,
    rate: Double
) {

    Row(
        modifier = Modifier.fillMaxWidth().padding(Dimensions.Padding.sm)
    ) {
        Column {
            Text(text = "$name")
        }
        Column {
            Text(text = "$rate")
        }
    }

}

