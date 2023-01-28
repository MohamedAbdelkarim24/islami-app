package com.route.islami

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.route.islami.fragments.AhadeethFragment
import com.route.islami.fragments.QuranFragment
import com.route.islami.fragments.RadioFragment
import com.route.islami.fragments.TasbeehFragment

class MainActivity : AppCompatActivity() {
    lateinit var bottomNavigationView:BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationView=findViewById(R.id.bottom_navigation_view)
        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.quran -> {
                    setFragment(QuranFragment())
                }
                R.id.ahadeth -> {
                    setFragment(AhadeethFragment())
                }
                R.id.tasbeeh -> {
                    setFragment(TasbeehFragment())
                }
                R.id.radio -> {
                    setFragment(RadioFragment())
                }
            }
            return@setOnItemSelectedListener true
        }
        bottomNavigationView.selectedItemId=(R.id.quran)
    }
    fun setFragment(fragment:Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container_frame,fragment).commit()
    }
}