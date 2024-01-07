package com.example.mybank.di

import com.example.mybank.data.local.AccountRepository
import com.example.mybank.data.local.AppDatabase
import com.example.mybank.data.remote.RatesApiService
import com.example.mybank.presentation.viewModel.CurrenciesViewModel
import com.example.mybank.presentation.viewModel.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val AppModules = module {

    single { AppDatabase.getInstance(androidContext()).accountDao() }

    single { AccountRepository(get()) }

    single { RatesApiService(androidContext().applicationContext) }

    viewModel { MainViewModel(get()) }
    viewModel { CurrenciesViewModel(get(),get()) }
}