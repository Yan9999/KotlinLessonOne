package com.example.kotlinlessonone.model

import com.example.kotlinlessonone.domain.Weather

class RepositoryRemoteImpl:MediaCenterRu{

    override fun getWeather(lat: Double, Lon: Double): Weather {

            Thread {
                Thread.sleep(300L)

            }.start()
            return Weather()
        }
    }