package com.route.islamic41.ui.main.fragments.ahadeth

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.route.islamic41.databinding.ItemHadethBinding
import com.route.islamic41.model.Hadeth

class AhadethAdapter(val ahadethList: MutableList<Hadeth>, var onHadethClick: (Hadeth) -> Unit) :
    Adapter<AhadethAdapter.AhadethViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AhadethViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemHadethBinding.inflate(layoutInflater, parent, false)
        return AhadethViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AhadethViewHolder, position: Int) {
        val hadeth = ahadethList[position]
        holder.binding.root.setOnClickListener {
            onHadethClick(hadeth)
        }
        holder.binding.itemHadethTitle.text = hadeth.title
        holder.binding.itemHadethContent.text = hadeth.content
    }

    override fun getItemCount(): Int = ahadethList.size

    class AhadethViewHolder(var binding: ItemHadethBinding) : RecyclerView.ViewHolder(binding.root)
}