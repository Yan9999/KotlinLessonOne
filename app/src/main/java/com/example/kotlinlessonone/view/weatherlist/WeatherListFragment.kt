package com.example.kotlinlessonone.view.weatherlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinlessonone.databinding.FragmentWeatherListBinding
import com.example.kotlinlessonone.viewmodel.AppState
import com.example.kotlinlessonone.viewmodel.AppStateSecond

class WeatherListFragment:Fragment(){
    companion object{
        fun newInstance() = WeatherListFragment()
        }
         lateinit var  bindin :FragmentWeatherListBinding
         lateinit var viewModel: WeatherListViewModel
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
      bindin = FragmentWeatherListBinding.inflate(inflater)
        return bindin.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(WeatherListViewModel::class.java)
        viewModel.liveData.observe(viewLifecycleOwner, object:Observer<AppState>{
            override fun onChanged(t: AppState) {

                renderData(t)
            } })
    viewModel.sentReqest()
    }
    private fun renderData(appState: AppState){
        val state = AppState.Success(Any())
        when (appState){
            is AppState.Error -> { }
            AppState.Loading -> {}
            is AppState.Success -> {
                val result = appState.weatherData
                Toast.makeText(requireContext(), "Работает $result", Toast.LENGTH_LONG ).show()
            }
            else -> {}
        }
        }
    }

