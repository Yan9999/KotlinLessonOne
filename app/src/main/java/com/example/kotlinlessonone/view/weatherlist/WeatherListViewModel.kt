package com.example.kotlinlessonone.view.weatherlist
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinlessonone.model.Repository
import com.example.kotlinlessonone.model.RepositoryLocalImpl
import com.example.kotlinlessonone.model.RepositoryRemoteImpl
import com.example.kotlinlessonone.viewmodel.AppState
import java.lang.IllegalStateException
import java.lang.Thread.sleep


class WeatherListViewModel(private val liveData: MutableLiveData<AppState> = MutableLiveData<AppState>()) :
        ViewModel() {

lateinit var  repository:Repository


    fun getLiveData():MutableLiveData<AppState>{
        choiceRepository()
        return liveData
    }

    fun choiceRepository(){
        if(isConnection()){
            repository = RepositoryRemoteImpl()
        }else{
            repository = RepositoryLocalImpl()
        }
    }

    fun sentRequest() {
       // choiceRepository()  if(isConnection())
        liveData.value = AppState.Loading

        if((0..3).random()==1){
            liveData.postValue(AppState.Error(throw IllegalStateException("Что-то не так так так ")))

        }else{
            liveData.postValue(AppState.Success(repository.getWeather(55.755826, 37.617299900000035)))
        }


    }

    private fun isConnection(): Boolean {
        return false
    }
}