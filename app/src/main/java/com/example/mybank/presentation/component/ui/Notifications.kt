package com.example.mybank.presentation.component.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun NotificationItem(title: String) {
    Column {
        Text(text = title)
    }
}

@Composable
fun Notifications() {
    LazyColumn{
        items(3){
            NotificationItem(title = "AAA")
        }
    }
}

@Composable
fun NotificationsBox() {
    val isExpanded = remember {
        mutableStateOf(false
        )
    }
    DropdownMenu(expanded = isExpanded.value, onDismissRequest = { isExpanded.value = false }) {

        Notifications()
    }
}