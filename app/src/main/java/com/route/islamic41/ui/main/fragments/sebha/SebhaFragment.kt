package com.route.islamic41.ui.main.fragments.sebha

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islamic41.databinding.FragmentSebhaBinding

class SebhaFragment : Fragment() {
    lateinit var binding: FragmentSebhaBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        frameLayout: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSebhaBinding.inflate(inflater, frameLayout, false)
        return binding.root
    }
}