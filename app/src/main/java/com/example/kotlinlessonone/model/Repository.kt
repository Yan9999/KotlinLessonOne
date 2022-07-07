package com.example.kotlinlessonone.model

import com.example.kotlinlessonone.domain.Weather

interface MediaCenterRu{
    fun getWeather(lat:Double, Lon: Double ):Weather
}
interface MediaCenterWorld {
    fun getListWeather(Location:Locations):List<Weather>
}

sealed class Locations{
    object Russian: Locations()
    object World: Locations()

}