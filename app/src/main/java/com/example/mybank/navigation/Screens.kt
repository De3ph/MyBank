package com.example.mybank.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.mybank.R

sealed class Screens(
    val id: Int,
    var label: String,
    var route: String,
    var defaultIcon: ImageVector? = null,
    var activeIcon: ImageVector? = null,
    var iconId: Int? = null
) {
    data object MainScreen : Screens(
        1, "Home", "/",
        defaultIcon = Icons.Outlined.Home, activeIcon = Icons.Filled.Home
    )

    data object ProfileScreen : Screens(
        1, "Profile", "/profile",
        defaultIcon = Icons.Outlined.AccountCircle, activeIcon = Icons.Filled.AccountCircle
    )

    data object CurrencyScreen : Screens(
        1, "Currencies", "/currency",
        iconId = R.drawable.monitoring
    )
}

val ScreenList = listOf<Screens>(
    Screens.MainScreen,
    Screens.CurrencyScreen,
    Screens.ProfileScreen,
)