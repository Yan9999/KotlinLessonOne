package com.example.kotlinlessonone.view.details

import com.example.kotlinlessonone.domain.Weather

interface OnItemClick {
    fun onItemClick(weather: Weather)
}