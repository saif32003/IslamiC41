package com.route.islamic41.ui.main.fragments.quran

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.route.islamic41.databinding.ItemSuraBinding
import com.route.islamic41.model.Sura

class SurasAdapter(val suraList: ArrayList<Sura>, val onSuraClick: (Sura, Int) -> Unit) :
    Adapter<SurasAdapter.SurasViewHolder>() {

    override fun onCreateViewHolder(recyclerView: ViewGroup, viewType: Int): SurasViewHolder {
        val inflater = LayoutInflater.from(recyclerView.context)
        val binding = ItemSuraBinding.inflate(inflater, recyclerView, false)
        return SurasViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SurasViewHolder, position: Int) {
        val sura = suraList[position]
        holder.binding.suraNumberText.text = "${position + 1}"
        holder.binding.suraNameEn.text = sura.nameEn
        holder.binding.suraNameAr.text = sura.nameAr
        holder.binding.suraVerses.text = sura.verses
        holder.binding.root.setOnClickListener {
            onSuraClick(sura, position)
        }
    }

    override fun getItemCount(): Int = suraList.size

    class SurasViewHolder(val binding: ItemSuraBinding) : ViewHolder(binding.root)
}
