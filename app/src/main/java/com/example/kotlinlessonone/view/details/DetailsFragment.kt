package com.example.kotlinlessonone.view.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinlessonone.databinding.FragmentDetailsBinding
import com.example.kotlinlessonone.databinding.FragmentWeatherListBinding
import com.example.kotlinlessonone.domain.Weather
import com.example.kotlinlessonone.view.weatherlist.WeatherListFragment
import com.example.kotlinlessonone.view.weatherlist.WeatherListViewModel
import com.example.kotlinlessonone.viewmodel.AppState

class DetailsFragment: Fragment() {


    private var  _binding : FragmentDetailsBinding? = null
    private val  binding : FragmentDetailsBinding
        get(){
            return _binding!!
        }

    override fun onDestroy(){
        super.onDestroy()
        _binding = null
    }

    lateinit var viewModel: WeatherListViewModel
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding =  FragmentDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

      val weather = (arguments?.getParcelable<Weather>(BAD_EXTRA))
        if (weather!=null)
        renderData(weather)
    }
    private fun renderData(weather: Weather){

            binding.cityName.text = weather.city.name
            binding.temperatureValue.text = weather.template.toString()
            binding.feelsLikeValue.text = weather.feelsLike.toString()
            binding.cityCoordinates.text = "${weather.city.lat}/${weather.city.lon}"
            Toast.makeText(requireContext(), "Работает $weather", Toast.LENGTH_LONG).show()

            }

    companion object{
        const val BAD_EXTRA="BAD"
        fun newInstance(weather:Weather):DetailsFragment {
            val bundle =Bundle()
            bundle.putParcelable(BAD_EXTRA,weather)
            val fragment = DetailsFragment()
            fragment.arguments = bundle
            return fragment
        }

        }
    }
