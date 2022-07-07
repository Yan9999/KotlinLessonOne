package com.example.kotlinlessonone.TestPac

import android.util.Log

class TestTwo {
lateinit var testOne:TestOne

var extra = fun (string:String):Unit{
    Log.d("@@@", "родное тело")
}
    val extraR ={string:String-> Log.d("@@@", "телооо")}

fun sExtra (block:(string:String)-> Unit){
    extra=block
}

fun sayHiToTestOne (string:String){
    testOne.receiveMassage(string)

    testOne.receiveMassage("$string extra")
}
}