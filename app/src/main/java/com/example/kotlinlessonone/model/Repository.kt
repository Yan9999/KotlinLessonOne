package com.example.kotlinlessonone.model

import android.location.Location
import com.example.kotlinlessonone.domain.Weather

interface RepositoryOne {
    fun getWeather(lat:Double, Lon: Double ):Weather
}
interface RepositoryMany {
    fun getListWeather(Location:Locations):List<Weather>
}

sealed class Locations{
    object Russian: Locations()
    object World: Locations()

}