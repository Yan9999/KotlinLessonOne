package com.example.kotlinlessonone.TestPac

import android.util.Log

class TestOne {


    var extra = fun (string:String):Unit{
        Log.d("@@@", "родное тело")
    }

    fun receiveMassage(string: String) {
        Log.d("@@@", " получили $string")
    }
}