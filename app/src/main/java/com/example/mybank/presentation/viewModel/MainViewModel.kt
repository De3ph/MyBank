package com.example.mybank.presentation.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mybank.data.local.AccountDto
import com.example.mybank.data.local.AccountRepository
import com.example.mybank.data.local.toAccountDto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class HomeScreenUiState(
    var accounts: List<AccountDto>? = null
)

class MainViewModel(private val accountRepository: AccountRepository) : ViewModel() {

    private var _uiState = MutableStateFlow(HomeScreenUiState())
    val uiState = _uiState.asStateFlow()

    init {
        Log.d("init", "init main-view-model")
        viewModelScope.launch {
            _uiState.update { currentState ->
                currentState.copy(
                    accounts = accountRepository.getAll().map { it.toAccountDto() }
                )
            }
        }
    }
}