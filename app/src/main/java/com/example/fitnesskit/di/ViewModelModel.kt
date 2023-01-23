package com.example.fitnesskit.di

import com.example.fitnesskit.feature.presentation.ScheduleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModel = module {

    viewModel { ScheduleViewModel(get()) }
}