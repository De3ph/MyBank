package com.example.mybank.presentation.component.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.example.mybank.presentation.viewModel.CurrenciesViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun RateList() {
    val currenciesViewModel = koinViewModel<CurrenciesViewModel>()
    var state = currenciesViewModel.uiState.collectAsState();
    var ratesPairs = state.value.rates?.toList()

    LazyColumn {
        ratesPairs?.size?.let {length ->
            items(length){index ->
                RateListItem(name = ratesPairs[index].first, rate = ratesPairs[index].second)
            }
        }
    }
}