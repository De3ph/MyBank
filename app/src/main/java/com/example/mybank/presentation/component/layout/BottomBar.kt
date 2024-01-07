package com.example.mybank.presentation.component.layout

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.mybank.R
import com.example.mybank.navigation.ScreenList

@Composable
fun BottomBar(
    navController: NavController
) {
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry.value?.destination?.route

    NavigationBar {
        ScreenList.map {

            val isActive = currentDestination === it.route

            NavigationBarItem(
                selected = isActive,
                onClick = { navController.navigate(it.route) },
                alwaysShowLabel = false,
                label = {
                    Text(text = it.label)
                },
                icon = {
                    if (it.iconId !== null){
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.monitoring),
                            contentDescription = "${it.label} icon",
                            tint = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                    else{
                        Icon(
                            imageVector = (if (isActive) it.activeIcon else it.defaultIcon)!!,
                            contentDescription = "${it.label} icon",
                            tint = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                },
                colors = NavigationBarItemDefaults
                    .colors(
                        indicatorColor = MaterialTheme.colorScheme.surface
                    )
            )
        }
    }
}