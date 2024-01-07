package com.example.mybank.presentation.component.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.mybank.presentation.viewModel.MainViewModel
import com.example.mybank.constant.Dimensions
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AccountCardPager() {

    val viewModel = koinViewModel<MainViewModel>()
    var accounts = viewModel.uiState.collectAsState().value.accounts

    val pagerState = rememberPagerState { accounts?.size ?: 0 }

    Text(text = "Accounts", style = MaterialTheme.typography.headlineSmall)

    Spacer(modifier = Modifier.height(Dimensions.Spacing.md))

    HorizontalPager(state = pagerState) { index ->
        accounts?.get(index)?.let {
            AccountCard(
                name = it.name,
                iban = it.iban,
                balance = it.balance,
                currencyType = it.currencyType
            )
        }
    }

}