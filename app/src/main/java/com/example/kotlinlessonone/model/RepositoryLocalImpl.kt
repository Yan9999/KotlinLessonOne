package com.example.kotlinlessonone.model

import com.example.kotlinlessonone.domain.Weather
import com.example.kotlinlessonone.domain.getRussianCities
import com.example.kotlinlessonone.domain.getWorldCities

class RepositoryLocalImpl:MediaCenterWorld,MediaCenterRu {


    override fun getListWeather(Location: Locations): List<Weather> {
      return when(Location){
           Locations.Russian -> {
               getRussianCities()}
           Locations.World -> {
               getWorldCities()
           }
       }
    }

    override fun getWeather(lat: Double, Lon: Double): Weather {
        return Weather()
    }
}