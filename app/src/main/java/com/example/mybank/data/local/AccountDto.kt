package com.example.mybank.data.local

import com.example.mybank.constant.AvailableCurrencies
import io.mcarle.konvert.api.KonvertTo

@KonvertTo(Account::class)
data class AccountDto(
    var name: String,
    var iban: String,
    var balance: Double,
    var currencyType: AvailableCurrencies
)