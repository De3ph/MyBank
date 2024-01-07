package com.example.mybank.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mybank.presentation.screen.CurrencyScreen
import com.example.mybank.presentation.screen.MainScreen
import com.example.mybank.presentation.screen.ProfileScreen

@Composable
fun NavGraph(
    navController: NavController,
) {

    NavHost(navController = navController as NavHostController, startDestination = Screens.MainScreen.route) {
        composable(Screens.MainScreen.route) {
            MainScreen(navController)
        }
        composable(Screens.CurrencyScreen.route){
            CurrencyScreen()
        }
        composable(Screens.ProfileScreen.route) {
            ProfileScreen()
        }
    }
}