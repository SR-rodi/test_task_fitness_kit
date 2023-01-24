package com.example.fitnesskit.core

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel<T : Any> : ViewModel() {

    protected val _schedule = MutableStateFlow<List<T>>(emptyList())
    val schedule = _schedule.asStateFlow()

    protected val _loadState = MutableStateFlow(LoadState.LOADING)
    val loadState = _loadState.asStateFlow()

   protected val handler = CoroutineExceptionHandler { _, T ->
        Log.e("Kart", "${T.message}")
        _loadState.value = LoadState.ERROR
    }
}