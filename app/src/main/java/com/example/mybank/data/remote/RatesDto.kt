package com.example.mybank.data.remote

data class RatesDto(
    var base: String,
    var rates : Map<String, Double>
) {
}