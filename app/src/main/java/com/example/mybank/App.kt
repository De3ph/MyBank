package com.example.mybank

import android.app.Application
import com.example.mybank.di.AppModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@App)
            modules(AppModules)
        }
    }
}