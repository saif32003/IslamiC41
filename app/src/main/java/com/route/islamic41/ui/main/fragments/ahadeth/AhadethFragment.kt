package com.route.islamic41.ui.main.fragments.ahadeth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islamic41.databinding.FragmentAhadethBinding
import com.route.islamic41.model.Hadeth
import com.route.islamic41.ui.hadeth_details.HadethActivity
import java.io.BufferedReader
import java.io.InputStreamReader

class AhadethFragment : Fragment() {
    var ahadethList: MutableList<Hadeth> = mutableListOf()
    lateinit var ahadethAdapter: AhadethAdapter
    lateinit var binding: FragmentAhadethBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        readHadethFile()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        frameLayout: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAhadethBinding.inflate(inflater, frameLayout, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAhadethRecyclerView()

    }

    private fun initAhadethRecyclerView() {
        binding.ahadethRecyclerView.apply {
            set3DItem(true)
            setAlpha(true)
            setInfinite(true)
        }
        ahadethAdapter = AhadethAdapter(ahadethList) {
            val intent = Intent(requireContext(), HadethActivity::class.java)
            intent.putExtra(HadethActivity.HADETH_KEY, it)
            startActivity(intent)
        }
        binding.ahadethRecyclerView.adapter = ahadethAdapter
    }

    fun readHadethFile() {
        var reader: BufferedReader?
        reader = BufferedReader(
            InputStreamReader(
                requireActivity().assets.open("ahadeth/ahadeth.txt"),
                "UTF-8"
            )
        )
        var line = reader.readLine()
        var title = ""
        var content = StringBuffer()
        var isReadingFirstLine = true
        while (line != null) {
            if (line == "#") {
                ahadethList.add(Hadeth(title = title, content = content.toString()))
                content = StringBuffer()
                isReadingFirstLine = true
            } else {
                if (isReadingFirstLine) {
                    title = line
                    isReadingFirstLine = false
                } else {
                    content.append(line)
                }
            }
            line = reader.readLine()
        }
    }
}