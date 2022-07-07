package com.example.kotlinlessonone.view.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.kotlinlessonone.databinding.FragmentDetailsBinding
import com.example.kotlinlessonone.domain.Weather
import com.example.kotlinlessonone.view.weatherlist.WeatherListViewModel

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

        arguments?.apply {  }
        arguments?.also {  }
        arguments?.run {  }
      //
        //val weather = (arguments?.getParcelable<Weather>(BAD_EXTRA))
        val weather = arguments?.let{arg->
            arg.getParcelable<Weather>(BAD_EXTRA)
        }
        if (weather!=null)
        renderData(weather)
        this.binding
        binding
    }
    private fun renderData(weather: Weather){

        binding?.apply { this.cityName
        cityName
        }

            val resAlso = binding?.also { newIt->
                newIt.cityName.text = ""
            val result = binding?.let {bindingMy ->
                bindingMy.cityName.toString()
                bindingMy.cityCoordinates.toString()
            }
            }

        val resRun = binding?.run { this.cityName.toString()}
        val resLet = binding?.let { bindingMy ->
           bindingMy.cityName.toString()
            bindingMy.cityCoordinates.toString()

        }

   with  (binding) {
    cityName.text = weather.city.name
    binding.temperatureValue.text = weather.template.toString()
    this.feelsLikeValue.text = weather.feelsLike.toString()
    this.cityCoordinates.text = "${weather.city.lat}/${weather.city.lon}"

}
        Toast.makeText(requireContext(), "Работает $weather", Toast.LENGTH_LONG).show()
            }

    companion object{
        const val BAD_EXTRA="BAD"
        fun newInstance(weather:Weather)=DetailsFragment().also { fr->
            fr.arguments = Bundle().apply {
                    this.putParcelable(BAD_EXTRA,weather)
                    putParcelable(BAD_EXTRA,weather)
                }
            fr.arguments = Bundle().apply {
                this.putParcelable(BAD_EXTRA,weather)
                putParcelable(BAD_EXTRA,weather)
            }

            }
        }

        }

