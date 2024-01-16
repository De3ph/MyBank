package com.example.mybank.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.mybank.constant.Dimensions
import com.example.mybank.presentation.component.ui.AccountCardPager
import com.example.mybank.presentation.component.ui.ExpenseList
import com.example.mybank.presentation.component.ui.GreetingBar

@Composable
fun MainScreen(
    navController: NavController
){

    Column(
        Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(Dimensions.Spacing.xxl)
    ) {
        GreetingBar(name = "Hamit Can", navController)

        Column(
            Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(Dimensions.Spacing.xxl * 2)
        ) {
            AccountCardPager()
            ExpenseList()
        }
    }
}