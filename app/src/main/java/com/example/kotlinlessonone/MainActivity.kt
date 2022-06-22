package com.example.kotlinlessonone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.kotlinlessonone.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val car:Car = Car("lada",4)

        findViewById<Button>(R.id.button0).setOnClickListener(object : View.OnClickListener { //
            // не понимаю как вынести это метод за MainActivity что бы было красиво
            override fun onClick(v: View?) {
                findViewById<TextView>(R.id.textView1).setText( "" + car.mileage  )
                findViewById<TextView>(R.id.textView0).setText( car.name)

            }
        })

        findViewById<Button>(R.id.button).setOnClickListener(object : View.OnClickListener { //
            // не понимаю как вынести это метод за MainActivity что бы было красиво
            override fun onClick(v: View?) {
                findViewById<TextView>(R.id.textView).setText( "Приыет мир ")
            }
        })

        val car2 = car.copy()

        findViewById<TextView>(R.id.textView2).setText( "марка "+car2.name+" Пробег "+car2.mileage)



        var index =1
        var ex = " "
        for(i in 1..10) {

            ex = ex+index
            findViewById<TextView>(R.id.textView3).setText(ex)
            index++


        }




    }
    }




data class Car( val name:String ="kia", var mileage:Int = 3 )





