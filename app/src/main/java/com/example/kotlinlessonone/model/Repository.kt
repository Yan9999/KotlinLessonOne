package com.example.kotlinlessonone.model

import com.example.kotlinlessonone.domain.Weather

interface Repository {

    fun getListWeather():List<Weather>
    fun getWeather(lat:Double, Lon: Double ):Weather
}