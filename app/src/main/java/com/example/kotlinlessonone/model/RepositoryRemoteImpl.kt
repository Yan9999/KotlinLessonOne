package com.example.kotlinlessonone.model

import android.location.Location
import com.example.kotlinlessonone.domain.Weather
import com.example.kotlinlessonone.domain.getRussianCities
import com.example.kotlinlessonone.domain.getWorldCities
import com.example.kotlinlessonone.viewmodel.AppState

class RepositoryRemoteImpl:MediaCenterRu{

    override fun getWeather(lat: Double, Lon: Double): Weather {

            Thread {
                Thread.sleep(300L)

            }.start()
            return Weather()
        }
    }