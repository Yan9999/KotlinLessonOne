package com.example.kotlinlessonone.view.weatherlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinlessonone.R
import com.example.kotlinlessonone.databinding.FragmentWeatherListBinding
import com.example.kotlinlessonone.domain.Weather
import com.example.kotlinlessonone.view.details.DetailsFragment
import com.example.kotlinlessonone.view.details.OnItemClick
import com.example.kotlinlessonone.viewmodel.AppState

class WeatherListFragment:Fragment(),OnItemClick{

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
                Toast.makeText(requireContext(), "Произогла ошибка, перезагрузите приложение ",Toast.LENGTH_LONG).show()
                binding.showResult()
            }
            AppState.Loading -> {
                Toast.makeText(requireContext(), "Идет загрузка ...", Toast.LENGTH_LONG).show()
                binding.Loading()
            }
            is AppState.SuccessOne -> {
                binding.showResult()
                val result = appState.weatherData
            }
            is AppState.SuccessMulti -> {
                binding.showResult()
                binding.mainFragmentRecyclerView.adapter = WeatherListAdapter(appState.weatherList,this)
            }
        }
    }



    fun FragmentWeatherListBinding.Loading (){
        this.mainFragmentLoadingLayout.visibility = View.VISIBLE
        this.weatherListFragmentFAB.visibility = View.GONE
    }
    fun FragmentWeatherListBinding.showResult(){
        this.mainFragmentLoadingLayout.visibility = View.GONE
        this.weatherListFragmentFAB.visibility = View.VISIBLE

    }
    override fun onItemClick(weather: Weather) {
        requireActivity().supportFragmentManager.beginTransaction().hide(this).add(
            R.id.container,
            DetailsFragment.newInstance(weather)
        ).addToBackStack("").commit()
    }
}

