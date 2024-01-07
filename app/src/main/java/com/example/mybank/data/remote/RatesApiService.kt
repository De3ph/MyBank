package com.example.mybank.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RatesApiService {
    val apiService: RatesApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://exchange-rate-api1.p.rapidapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RatesApi::class.java);
    }
}