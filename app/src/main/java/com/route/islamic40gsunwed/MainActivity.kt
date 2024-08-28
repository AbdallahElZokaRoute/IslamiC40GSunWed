package com.route.islamic40gsunwed

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.route.islamic40gsunwed.fragments.HadeethFragment
import com.route.islamic40gsunwed.fragments.QuranFragment
import com.route.islamic40gsunwed.fragments.RadioFragment
import com.route.islamic40gsunwed.fragments.TasbehFragment

class MainActivity : AppCompatActivity() {
    lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationView = findViewById(R.id.islami_bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener {
            val fragment = when (it.itemId) {
                R.id.navigation_quran -> QuranFragment()
                R.id.navigation_hadeeth -> HadeethFragment()
                R.id.navigation_tasbeeh -> TasbehFragment()
                R.id.navigation_radio -> RadioFragment()
                else -> QuranFragment()
            }
            showFragment(fragment)
            return@setOnItemSelectedListener true
        }
        bottomNavigationView.selectedItemId = R.id.navigation_quran
    }

    fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.islami_fragment_container, fragment)
            .commit()
    }
}