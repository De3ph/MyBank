package com.example.mybank.data.remote

import kotlinx.coroutines.flow.flow

class RatesApiService(private val apiBuilder: RatesApiBuilder) {

    suspend fun getRates() = flow {
        emit(apiBuilder.api.getRates())
    }

}