package com.example.mybank.presentation.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mybank.data.local.account.AccountDto
import com.example.mybank.data.local.account.AccountRepository
import com.example.mybank.data.local.account.toAccountDto
import com.example.mybank.data.local.expense.ExpenseDto
import com.example.mybank.data.local.expense.ExpenseRepository
import com.example.mybank.data.local.expense.toExpenseDto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class HomeScreenUiState(
    var accounts: List<AccountDto> = emptyList(),
    var expenses: List<ExpenseDto> = emptyList(),
    var currentAccountId: Int? = null
)

class MainViewModel(
    private val accountRepository: AccountRepository,
    private val expenseRepository: ExpenseRepository
) : ViewModel() {

    private var _uiState = MutableStateFlow(HomeScreenUiState())
    val uiState = _uiState.asStateFlow()

    init {
        Log.d("init", "init main-view-model")
        viewModelScope.launch {
            val accounts = accountRepository.getAll().map { it.toAccountDto() }
            val currentAccountId = accounts[0].id
            val expenses = expenseRepository.getExpenses(currentAccountId).map { it.toExpenseDto() }


            _uiState.update { currentState ->
                currentState.copy(
                    accounts = accounts,
                    expenses = expenses,
                    currentAccountId = currentAccountId
                )
            }

        }

    }

    fun updateCurrentAccount(id: Int) {
        Log.d("updateCurrentAccount", "updateCurrentAccount: viewmodel")
        var expenses: List<ExpenseDto>

        viewModelScope.launch {
            expenses = expenseRepository.getExpenses(id).map { it.toExpenseDto() }

            _uiState.update { currentState ->
                currentState.copy(
                    expenses = expenses,
                    currentAccountId = id
                )
            }
        }

    }

}