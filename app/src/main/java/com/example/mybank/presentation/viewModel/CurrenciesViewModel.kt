package com.example.mybank.presentation.viewModel

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mybank.data.remote.RatesApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class CurrenciesScreenUiState(
    var base: String? = null,
    var rates: Map<String, Double>? = null
)

class CurrenciesViewModel(
    ctx: Context,
    private val ratesApiService: RatesApiService
) : ViewModel() {

    private var _uiState = MutableStateFlow(CurrenciesScreenUiState())
    val uiState = _uiState.asStateFlow()

    init {
        Log.d("init", "init currencies-view-model")
        viewModelScope.launch {
            fetchRates()
        }
    }

    private suspend fun fetchRates() {
        ratesApiService.getRates()
            .catch { e -> Log.d("err", e.message.orEmpty()) }
            .collect { response ->
                if (response.isSuccessful) {

                    _uiState.update { currentState ->
                        currentState.copy(
                            base = response.body()?.base,
                            rates = response.body()?.rates
                        )
                    }
                }
            }
    }
}