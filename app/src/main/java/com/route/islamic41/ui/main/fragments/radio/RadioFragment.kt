package com.route.islamic41.ui.main.fragments.radio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islamic41.databinding.FragmentRadioBinding

class RadioFragment : Fragment() {
    lateinit var binding: FragmentRadioBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        frameLayout: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentRadioBinding.inflate(inflater, frameLayout, false)
        return binding.root
    }
}