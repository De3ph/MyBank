package com.example.mybank.constant

enum class AvailableCurrencies(val symbol: String, val toString: () -> String) {
    DOLLAR("$", { "DOLLAR" }),
    EURO("€", { "EURO" }),
    STERLIN("£", { "STERLIN" }),
    TURKISH_LIRA("₺", { "TURKISH-LIRA" })
}