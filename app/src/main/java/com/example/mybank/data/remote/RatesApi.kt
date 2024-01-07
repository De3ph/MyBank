package com.example.mybank.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface RatesApi {
    @Headers(
        /* TODO */
        "X-RapidAPI-Key: 091e06f20amsh3cb04795e5aab32p173a2bjsn5cc14b59a9af",
        "X-RapidAPI-Host: exchange-rate-api1.p.rapidapi.com"
    )
    @GET(
        "/latest?base=USD"
    )
    suspend fun getRates() : Response<Rates>
}