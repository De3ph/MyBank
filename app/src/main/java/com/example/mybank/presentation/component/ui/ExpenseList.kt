package com.example.mybank.presentation.component.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.mybank.constant.Dimensions
import com.example.mybank.presentation.viewModel.MainViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ExpenseList() {

    val expenses = koinViewModel<MainViewModel>().uiState.collectAsState().value.expenses

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Dimensions.Padding.sm, vertical = Dimensions.Padding.lg),
        verticalArrangement = Arrangement.spacedBy(Dimensions.Spacing.sm)
    ) {
        Text(text = "Last 30 Expenses", style = MaterialTheme.typography.titleLarge.copy(
            fontWeight = FontWeight.SemiBold
        ))
        Divider()

        LazyColumn(
            Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(Dimensions.Spacing.sm),
            contentPadding = PaddingValues(vertical = Dimensions.Padding.xs)
        ) {
            items(expenses.size ?: 0) {
                ExpenseListItem(
                    modifier = Modifier.fillMaxWidth(),
                    dto = expenses[it]
                )
            }
        }
    }
}
