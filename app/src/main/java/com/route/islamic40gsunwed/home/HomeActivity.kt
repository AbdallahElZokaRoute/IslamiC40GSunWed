package com.route.islamic40gsunwed.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.route.islamic40gsunwed.R
import com.route.islamic40gsunwed.base.BaseActivity
import com.route.islamic40gsunwed.databinding.ActivityHomeBinding
import com.route.islamic40gsunwed.home.hadeth.HadethFragment
import com.route.islamic40gsunwed.home.quran.QuranFragment
import com.route.islamic40gsunwed.home.tsbeeh.TsbehFragment


class HomeActivity:BaseActivity<ActivityHomeBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding!!.root)
        binding!!.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.quran -> showFragment(QuranFragment())
                R.id.ahadeth->showFragment(HadethFragment())
                R.id.tsbeh -> showFragment(TsbehFragment())
            }
            return@setOnItemSelectedListener true
        }
        binding!!.bottomNavigation.selectedItemId = R.id.quran
    }

        override fun initViewBinding(): ActivityHomeBinding =
            ActivityHomeBinding.inflate(layoutInflater)
      fun showFragment(fragment:Fragment){
          supportFragmentManager.beginTransaction()
              .replace(R.id.fragment_container,fragment)
              .commit()
      }

}