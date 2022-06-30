package com.example.kotlinlessonone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinlessonone.databinding.ActivityMainBinding
import com.example.kotlinlessonone.view.weatherlist.WeatherListFragment

class MainActivity : AppCompatActivity() {
    lateinit var bindinq: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindinq = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindinq.myRoot)
       // bindinq.textView.text = "Тута-Матута"

        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction().replace(R.id.textView,WeatherListFragment.newInstance()).commit()
        }
    }

}







