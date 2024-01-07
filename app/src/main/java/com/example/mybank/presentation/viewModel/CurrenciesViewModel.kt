package com.example.mybank.presentation.viewModel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mybank.data.remote.RatesApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
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

        viewModelScope.launch(Dispatchers.IO) {

            try {

                val response = ratesApiService.apiService.getRates()
                if (response.isSuccessful) {

                    _uiState.update { currentState ->
                        currentState.copy(
                            base = response.body()?.base,
                            rates = response.body()?.rates
                        )
                    }
                }
            } catch (e: Exception) {
                Log.d("e", e.message.toString())
                Toast.makeText(ctx,"An error occured when fetching data",Toast.LENGTH_SHORT).show();
            }


        }
    }
}