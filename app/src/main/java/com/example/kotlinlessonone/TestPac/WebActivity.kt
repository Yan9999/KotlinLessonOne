package com.example.kotlinlessonone.TestPac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.example.kotlinlessonone.databinding.ActivityWebBinding
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.util.stream.Collector
import java.util.stream.Collectors

class WebActivity : AppCompatActivity() {

    lateinit var binding:ActivityWebBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ok.setOnClickListener{
            binding.url.text.let { textUrl ->
                var ConnectionMy: HttpURLConnection? = null
             val uri = URL(it.toString())

                ConnectionMy = uri.openConnection() as HttpURLConnection

                ConnectionMy.readTimeout = 500
                val handler = Handler(Looper.myLooper()!!)
                Thread{
                    val reader = BufferedReader(InputStreamReader(ConnectionMy.inputStream))
                    val result = getLines (reader)
                    Log.d("@@@", result)
                     getLines(reader)
                    handler.post( object :Runnable{
                        override fun run() {
                            binding.webview.loadDataWithBaseURL(null,result,"text/xml; charset = utf-8","utf-8",null)
                        }
                    }

                    )


                }.start()


            }
        }
    }



    private fun getLines(readeer:BufferedReader):String{
        return readeer.lines().collect(Collectors.joining(" \n"))

    }
}