package com.example.mybank.data.remote

import io.mcarle.konvert.api.KonvertTo
import io.mcarle.konvert.api.Mapping

@KonvertTo(
    RatesDto::class, mappings = [
        Mapping(source = "base", target = "base"),
        Mapping(source = "rates", target = "rates")
    ]
)
data class Rates(
    val code: String,
    val msg: String,
    val base: String,
    val rates: Map<String, Double>,
    val time_update: TimeUpdate
)

data class TimeUpdate(
    val time_unix: Long,
    val time_utc: String,
    val time_zone: String
)