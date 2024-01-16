package com.example.mybank.presentation.component.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.example.mybank.data.local.expense.ExpenseDto

@Composable
fun ExpenseList(expenses : List<ExpenseDto>) {
    LazyColumn{
        items(expenses.size){
            ExpenseListItem(dto = expenses[it])
        }
    }
}