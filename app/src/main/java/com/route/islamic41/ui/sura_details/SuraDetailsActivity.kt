package com.route.islamic41.ui.sura_details

import android.os.Build
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.route.islamic41.databinding.ActivitySuraDetailsBinding
import com.route.islamic41.model.Sura
import java.io.BufferedReader
import java.io.InputStreamReader


class SuraDetailsActivity : AppCompatActivity() {
    companion object {
        const val FILE_NAME = "fileName"
        const val SURA = "sura"
    }

    private lateinit var binding: ActivitySuraDetailsBinding
    lateinit var fileName: String
    lateinit var sura: Sura

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuraDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fileName = intent.getStringExtra(FILE_NAME)!!
        sura = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra(SURA, Sura::class.java)!!
        } else {
            intent.getSerializableExtra(SURA) as Sura
        }
        bindData()
        initListeners()
    }

    override fun onResume() {
        super.onResume()
        readFile()
        binding.suraContent.text = suraContent
    }

    private fun initListeners() {
        binding.arrowBack.setOnClickListener {
            finish()
        }
    }

    private fun bindData() {
        binding.suraNameEn.text = sura.nameEn
        binding.suraNameAr.text = sura.nameAr
        binding.suraContent.text = suraContent
        binding.suraContent.movementMethod = ScrollingMovementMethod()
    }

    var suraContent = StringBuffer()
    private fun readFile() {

        var reader: BufferedReader?
        reader = BufferedReader(
            InputStreamReader(assets.open("suras/$fileName"), "UTF-8")
        )
        var mLine = reader.readLine()
        var i = 1
        while (mLine != null) {
            if (mLine.isNotEmpty())
                suraContent.append(mLine + " {${i}} ")
            mLine = reader.readLine()
            i++
        }
        Log.e("Sura", "$suraContent")
    }
}