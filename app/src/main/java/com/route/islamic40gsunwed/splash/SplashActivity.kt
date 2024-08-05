package com.route.islamic40gsunwed.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.route.islamic40gsunwed.base.BaseActivity
import com.route.islamic40gsunwed.databinding.ActivitySplashBinding
import com.route.islamic40gsunwed.home.HomeActivity

class SplashActivity:BaseActivity<ActivitySplashBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding!!.root)
        Handler(Looper.getMainLooper()).postDelayed({
            navigateToHome()
        },3000)
    }

    override fun initViewBinding(): ActivitySplashBinding = ActivitySplashBinding.inflate(layoutInflater)

    fun navigateToHome(){
        var intent: Intent = Intent(this@SplashActivity, HomeActivity::class.java)
        startActivity(intent)
    }

}