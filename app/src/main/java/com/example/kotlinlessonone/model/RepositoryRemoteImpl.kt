package com.example.kotlinlessonone.model

import com.example.kotlinlessonone.domain.Weather
import com.example.kotlinlessonone.viewmodel.AppState

class RepositoryRemoteImpl:Repository {
    override fun getListWeather(): List<Weather> {
        Thread {
            Thread.sleep(2000L)

        }.start()
        return listOf(Weather())
    }

    override fun getWeather(lat: Double, Lon: Double): Weather {

        Thread {
            Thread.sleep(300L)

        }.start()
        return Weather()
    }
}