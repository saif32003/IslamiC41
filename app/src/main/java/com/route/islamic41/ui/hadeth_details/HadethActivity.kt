package com.route.islamic41.ui.hadeth_details

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.route.islamic41.databinding.ActivitySuraDetailsBinding
import com.route.islamic41.model.Hadeth

class HadethActivity : AppCompatActivity() {
    companion object {
        const val HADETH_KEY = "hadeth"
    }

    lateinit var binding: ActivitySuraDetailsBinding
    lateinit var hadeth: Hadeth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuraDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        hadeth = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
            intent.getSerializableExtra(HADETH_KEY, Hadeth::class.java)!!
        else intent.getSerializableExtra(HADETH_KEY) as Hadeth
        binding.arrowBack.setOnClickListener {
            finish()
        }
        binding.suraNameEn.isVisible = false
        binding.suraNameAr.text = hadeth.title
        binding.suraContent.text = hadeth.content
    }

    override fun onLowMemory() {
        super.onLowMemory()

    }
}