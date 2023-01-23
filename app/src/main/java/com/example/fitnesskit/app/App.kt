package com.example.fitnesskit.app

import android.app.Application
import com.example.fitnesskit.di.*
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                listOf(apiModule, networkRepositoryModule, networkUseCaseModule, viewModelModel)
            )
        }

    }
}