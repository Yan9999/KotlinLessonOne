package com.example.kotlinlessonone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.kotlinlessonone.R
import com.example.kotlinlessonone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var bindinq: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindinq = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindinq.root)
        bindinq.textView.text = "Тута-Матута"
    }

}







