package com.example.kotlinlessonone.viewmodel

import com.example.kotlinlessonone.domain.Weather

sealed class AppState {
    data class SuccessOne(val weatherData : Weather):AppState()
    data class SuccessMulti(val weatherList :List<Weather>):AppState()
    data class Error (val error:Throwable) :AppState()
    object Loading : AppState()
}
