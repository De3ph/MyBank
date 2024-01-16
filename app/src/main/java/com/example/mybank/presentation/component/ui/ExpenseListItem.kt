package com.example.mybank.presentation.component.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.mybank.data.local.expense.ExpenseDto
import com.example.mybank.data.local.utils.DateConverter

@Composable
fun ExpenseListItem(modifier : Modifier = Modifier ,dto: ExpenseDto?) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        dto?.title?.let {
            Text(text = it)
            Text(text = DateConverter.dateToTrString(dto.date))
        }
    }

}