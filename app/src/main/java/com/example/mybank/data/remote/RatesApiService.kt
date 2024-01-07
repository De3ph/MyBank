package com.example.mybank.data.remote

import android.content.Context
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

var cacheSize = 10 * 1024 * 1024 // 10 MB

class RatesApiService(context: Context) {

    private val cache = Cache(context.cacheDir, cacheSize.toLong())

    private val okHttpClient = OkHttpClient.Builder()
        .cache(cache)
        .build()

    val apiService: RatesApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://exchange-rate-api1.p.rapidapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(RatesApi::class.java);
    }
}
