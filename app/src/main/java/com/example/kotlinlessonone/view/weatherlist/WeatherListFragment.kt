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

class WeatherListFragment:Fragment(){
    companion object{
        fun newInstance() = WeatherListFragment()
        }
         lateinit var  binding :FragmentWeatherListBinding
         lateinit var viewModel: WeatherListViewModel
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
      binding = FragmentWeatherListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(WeatherListViewModel::class.java)
        viewModel.getLiveData().observe(viewLifecycleOwner, object:Observer<AppState>{
            override fun onChanged(t: AppState) {

                renderData(t)
            } })
    viewModel.sentRequest()
    }
    private fun renderData(appState: AppState){
        when (appState){
            is AppState.Error -> {
                Toast.makeText(requireContext(), "Произогла ошибка, перезагрузите приложение ",
                        Toast.LENGTH_LONG ).show()
            }
            AppState.Loading -> { Toast.makeText(requireContext(), "Идет загрузка ...", Toast.LENGTH_LONG ).show()}
            is AppState.Success -> {
                val result = appState.weatherData
                binding.cityName.text = result.city.name
                binding.temperatureValue.text = result.template.toString()
                binding.feelsLikeValue.text = result.feelsLike.toString()
                binding.cityCoordinates.text = "${result.city.lat}/${result.city.lon}"
                Toast.makeText(requireContext(), "Работает $result", Toast.LENGTH_LONG ).show()





            }

        }
        }
    }

