package com.route.islamic41.ui.main.fragments.quran

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islamic41.databinding.FragmentQuranBinding
import com.route.islamic41.ui.Constants
import com.route.islamic41.ui.sura_details.SuraDetailsActivity

class QuranFragment : Fragment() {
    lateinit var binding: FragmentQuranBinding
    lateinit var suraAdapter: SurasAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        suraAdapter = SurasAdapter(Constants.surasList) { sura, index ->
            val intent = Intent(requireContext(), SuraDetailsActivity::class.java)
            intent.putExtra(SuraDetailsActivity.FILE_NAME, "${index + 1}.txt")
            intent.putExtra(SuraDetailsActivity.SURA, sura)
            startActivity(intent)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        frameLayout: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuranBinding.inflate(inflater, frameLayout, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.surasRecyclerView.adapter = suraAdapter
    }
}