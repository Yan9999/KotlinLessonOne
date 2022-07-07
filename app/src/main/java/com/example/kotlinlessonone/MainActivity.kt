package com.example.kotlinlessonone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinlessonone.TestPac.TestOne
import com.example.kotlinlessonone.TestPac.TestTwo
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
            supportFragmentManager.beginTransaction().replace(R.id.container,WeatherListFragment.newInstance()).commit()
        }


        val testOne =TestOne()
        val testTwo = TestTwo()
         testTwo.testOne= testOne
        testTwo.extra= testOne.extra
        testTwo.sExtra(testOne.extra)

        testTwo.sayHiToTestOne("Hi")

        val res1 = testTwo.extra("")
        val res2 = testTwo.extraR("")

    }

}







