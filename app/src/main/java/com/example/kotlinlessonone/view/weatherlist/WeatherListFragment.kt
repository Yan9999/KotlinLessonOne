package com.example.kotlinlessonone.view.weatherlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinlessonone.R
import com.example.kotlinlessonone.databinding.FragmentWeatherListBinding
import com.example.kotlinlessonone.viewmodel.AppState

class WeatherListFragment:Fragment(){

    companion object{
        fun newInstance() = WeatherListFragment()
        }

    var isRussian = true
     private var  _binding :FragmentWeatherListBinding? = null
    private val  binding :FragmentWeatherListBinding
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
      _binding = FragmentWeatherListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(WeatherListViewModel::class.java)
        viewModel.getLiveData().observe(viewLifecycleOwner, object:Observer<AppState>{
            override fun onChanged(t: AppState) {
                renderData(t)
            } })

        binding.weatherListFragmentFAB.setOnClickListener{
            isRussian = !isRussian
            if(isRussian){
                viewModel.getWeatherListForRussia()
                binding.weatherListFragmentFAB.setImageResource(R.drawable.russia)
            }else{
                viewModel.getWeatherListForWorld()
                binding.weatherListFragmentFAB.setImageResource(R.drawable.images)
            }
        }
        viewModel.getWeatherListForRussia()
    }
    private fun renderData(appState: AppState){
        when (appState) {
            is AppState.Error -> {
                Toast.makeText(requireContext(), "Произогла ошибка, перезагрузите приложение ",
                        Toast.LENGTH_LONG).show()
            }
            AppState.Loading -> {
                Toast.makeText(requireContext(), "Идет загрузка ...", Toast.LENGTH_LONG).show()
            }
            is AppState.SuccessOne -> {
                val result = appState.weatherData
            }
            is AppState.SuccessMulti -> {
                binding.mainFragmentRecyclerView.adapter = WeatherListAdapter(appState.weatherList)
            }


        }
        }
    }

