package com.example.kotlinlessonone.viewmodel

import com.example.kotlinlessonone.domain.Weather

sealed class AppState {
    data class Success(val weatherData : Weather):AppState()

    data class Error (val error:Throwable) :AppState()
    object Loading : AppState()
}
