package com.example.mybank.data.local.expense

import com.example.mybank.constant.AvailableCurrencies
import io.mcarle.konvert.api.KonvertTo
import java.util.Date

@KonvertTo(Expense::class)
data class ExpenseDto(
    var title: String,
    var amount:Double,
    var currencyType: AvailableCurrencies,
    var accountId: Int,
    var date: Date
)
