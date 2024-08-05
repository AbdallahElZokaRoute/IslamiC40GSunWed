package com.route.islamic40gsunwed.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<T>:AppCompatActivity (){
     var binding:T? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = initViewBinding()
    }

    abstract fun initViewBinding():T

}