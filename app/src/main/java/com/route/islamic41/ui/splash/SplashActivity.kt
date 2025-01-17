package com.route.islamic41.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.route.islamic41.databinding.ActivitySplashBinding
import com.route.islamic41.ui.main.MainActivity

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Handler(Looper.getMainLooper()).postDelayed({
            startHomeScreen()
        }, 2000)
    }

    private fun startHomeScreen() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}