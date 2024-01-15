package com.example.mybank.presentation.component.ui

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mybank.R
import com.example.mybank.navigation.Screens

@Composable
fun GreetingBar(name: String, navController: NavController) {

    val context = LocalContext.current
    val msg = Toast.makeText(context, "Ok", Toast.LENGTH_SHORT)

    fun navigateToProfile() {
        navController.navigate(Screens.ProfileScreen.route)
    }

    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(
                space = 3.dp,
                alignment = Alignment.CenterVertically
            )
        ) {
            Text(
                text = "Tekrar hoşgeldin", style = MaterialTheme.typography.labelLarge.copy(
                    color = Color.Gray
                )
            )
            Text(text = name, style = MaterialTheme.typography.labelLarge)
        }

        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    OutlinedIconButton(
                        modifier = Modifier
                            .clip(CircleShape)
                            .wrapContentSize(),
                        border = BorderStroke(1.dp, Color.LightGray),
                        onClick = { msg.show() })
                    {
                        Image(imageVector = Icons.Outlined.Notifications, contentDescription = "")
                    }
                }
                Column {
                    OutlinedIconButton(
                        modifier = Modifier
                            .clip(CircleShape)
                            .wrapContentSize(),
                        border = BorderStroke(1.dp, Color.LightGray),
                        onClick = { navigateToProfile() })
                    {
                        Image(
                            modifier = Modifier.background(color = Color.Black),
                            painter = painterResource(id = R.drawable.ic_launcher_foreground),
                            contentDescription = "logo",
                            contentScale = ContentScale.Fit
                        )
                    }
                }
            }
        }
    }

}