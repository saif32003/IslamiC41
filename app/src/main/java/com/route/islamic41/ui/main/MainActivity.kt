package com.route.islamic41.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.route.islamic41.R
import com.route.islamic41.databinding.ActivityMainBinding
import com.route.islamic41.ui.main.fragments.ahadeth.AhadethFragment
import com.route.islamic41.ui.main.fragments.quran.QuranFragment
import com.route.islamic41.ui.main.fragments.radio.RadioFragment
import com.route.islamic41.ui.main.fragments.sebha.SebhaFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showFragment(QuranFragment())
        initListeners()
    }

    private fun initListeners() {
        binding.mainBottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.icQuran -> {
                    showFragment(QuranFragment())
                }

                R.id.icAhadeth -> {
                    showFragment(AhadethFragment())
                }

                R.id.icSebha -> {
                    showFragment(SebhaFragment())
                }

                R.id.icRadio -> {
                    showFragment(RadioFragment())
                }
            }
            return@setOnItemSelectedListener true
        }
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}