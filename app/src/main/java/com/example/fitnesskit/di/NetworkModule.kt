package com.example.fitnesskit.di

import com.example.fitnesskit.feature.data.api.ScheduleApi
import com.example.fitnesskit.feature.data.repository.ScheduleRepositoryImpl
import com.example.fitnesskit.feature.domaine.repository.ScheduleRepository
import com.example.fitnesskit.feature.domaine.usecase.ScheduleUseCase
import com.example.fitnesskit.feature.domaine.usecase.ScheduleUseCaseImpl
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

val apiModule = module {

    single(named("fitness_kit")) {
        Retrofit.Builder()
            .baseUrl("https://olimpia.fitnesskit-admin.ru/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<ScheduleApi> {
        get<Retrofit>(named("fitness_kit")).create()
    }
}

val networkRepositoryModule = module {

    single<ScheduleRepository> { ScheduleRepositoryImpl(get()) }
}

val networkUseCaseModule = module {
    single<ScheduleUseCase> { ScheduleUseCaseImpl(get()) }
}