package com.example.mybank.presentation.component.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.snapshotFlow
import com.example.mybank.presentation.viewModel.MainViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AccountCardPager() {

    val viewModel = koinViewModel<MainViewModel>()

    val state = viewModel.uiState.collectAsState()

    val pagerState = rememberPagerState { state.value.accounts.size ?: 0 }

    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect {
            if (state.value.accounts.isNotEmpty()) {
                viewModel.updateCurrentAccount(state.value.accounts[it].id)
            }
        }
    }

    HorizontalPager(state = pagerState) { index ->
        if (state.value.accounts.isNotEmpty()) {
            AccountCard(
                name = state.value.accounts[index].name,
                iban = state.value.accounts[index].iban,
                balance = state.value.accounts[index].balance,
                currencyType = state.value.accounts[index].currencyType
            )
        }
    }

}