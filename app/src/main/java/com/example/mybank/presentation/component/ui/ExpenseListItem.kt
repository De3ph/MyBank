package com.example.mybank.presentation.component.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.mybank.data.local.expense.ExpenseDto

@Composable
fun ExpenseListItem(dto: ExpenseDto) {
    Column {
        Text(text = dto.title)
    }

}