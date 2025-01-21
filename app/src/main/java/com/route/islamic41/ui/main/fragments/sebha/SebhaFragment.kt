package com.route.islamic41.ui.main.fragments.sebha

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islamic41.R
import com.route.islamic41.databinding.FragmentSebhaBinding

class SebhaFragment : Fragment() {
    lateinit var azkarList:MutableList<String>
    lateinit var binding: FragmentSebhaBinding
    private var currentIndex = 0
    private var counter = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        frameLayout: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSebhaBinding.inflate(inflater, frameLayout, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        azkarList = resources.getStringArray(R.array.azkarList).toMutableList()
        initView()
        onSebhaClick()
    }

    private fun initView(){
        binding.tvZikr.text = azkarList[currentIndex]
        binding.tvCounter.text ="$counter"
    }

    private fun onSebhaClick(){
        binding.sebha.setOnClickListener{
            binding.sebha.rotation += (360/33).toFloat()

            if(counter < 33){
                counter++
            } else {

                counter = 0
                val lastIndex = azkarList.size-1
                currentIndex = if (currentIndex < lastIndex) ++currentIndex else 0
                binding.tvZikr.text = azkarList[currentIndex]
            }
            binding.tvCounter.text = "$counter"
        }
    }
}