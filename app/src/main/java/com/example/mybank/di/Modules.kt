package com.example.mybank.di

import com.example.mybank.data.local.AppDatabase
import com.example.mybank.data.local.account.AccountRepository
import com.example.mybank.data.local.expense.ExpenseRepository
import com.example.mybank.data.remote.RatesApiBuilder
import com.example.mybank.data.remote.RatesApiService
import com.example.mybank.presentation.viewModel.CurrenciesViewModel
import com.example.mybank.presentation.viewModel.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val DatabaseModule = module {
    single<AppDatabase> {
        AppDatabase.getInstance(androidContext())
    }

    single { get<AppDatabase>().accountDao() }
    single { get<AppDatabase>().expenseDao() }

    single { AccountRepository(get()) }
    single { ExpenseRepository(get()) }
}

val ViewModelModule = module {
    viewModel { CurrenciesViewModel(get(), get()) }
    viewModel { MainViewModel(get(), get()) }
}


val AppModules = module {

    includes(DatabaseModule, ViewModelModule)

    single { RatesApiBuilder(androidContext().applicationContext) }

    single { RatesApiService(get()) }

}

