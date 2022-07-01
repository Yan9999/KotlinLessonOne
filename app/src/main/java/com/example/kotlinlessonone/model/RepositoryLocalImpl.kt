package com.example.kotlinlessonone.model

import com.example.kotlinlessonone.domain.Weather

class RepositoryLocalImpl:Repository {
    override fun getListWeather(): List<Weather> {
        return listOf(Weather())
    }

    override fun getWeather(lat: Double, Lon: Double): Weather {
        return Weather()
    }
}