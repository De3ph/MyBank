package com.example.mybank.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.mybank.constant.Dimensions
import com.example.mybank.presentation.component.ui.RateList

@Composable
fun CurrencyScreen() {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(Dimensions.Padding.md)) {
        RateList()
    }
}