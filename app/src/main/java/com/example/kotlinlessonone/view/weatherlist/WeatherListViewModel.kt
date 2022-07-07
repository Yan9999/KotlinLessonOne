package com.example.kotlinlessonone.view.weatherlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinlessonone.model.*
import com.example.kotlinlessonone.viewmodel.AppState


class WeatherListViewModel(private val liveData: MutableLiveData<AppState> = MutableLiveData<AppState>()) :
        ViewModel() {

lateinit var  mediaCenterWorld: MediaCenterWorld
    lateinit var  mediaCenterRu: MediaCenterRu


    fun getLiveData():MutableLiveData<AppState>{
        choiceRepository()
        return liveData
    }
    fun getWeatherListForRussia(){
        sentRequest(Locations.Russian)
    }
    fun getWeatherListForWorld(){
        sentRequest(Locations.World)
    }
     private fun choiceRepository(){
        if(isConnection()){
            mediaCenterRu = RepositoryRemoteImpl()
        }else{
            mediaCenterWorld = RepositoryLocalImpl()
        }
    }




    private fun sentRequest(Location:Locations) {
       // choiceRepository()  if(isConnection())
        liveData.value = AppState.Loading

        Thread {
            Thread.sleep(300L)
            if ((0..3).random() == 1) {
                liveData.postValue(AppState.Error(IllegalStateException("Что-то не так так так ")))

            } else {
                liveData.postValue(AppState.SuccessMulti(mediaCenterWorld.getListWeather(Location)))
            }
        }.start()


    }

    private fun isConnection(): Boolean {
        return false
    }
}