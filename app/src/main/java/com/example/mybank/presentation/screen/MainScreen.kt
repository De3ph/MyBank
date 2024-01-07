package com.example.mybank.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.mybank.presentation.component.ui.AccountCardPager

@Composable
fun MainScreen(
    navController: NavController
){
    Column(
        Modifier.fillMaxWidth()
    ) {
        AccountCardPager()
    }
}