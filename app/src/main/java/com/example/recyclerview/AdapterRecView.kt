package com.example.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ItemRecyclerBinding

class AdapterRecView(private val listWayang: ArrayList<DcWayang>) :
        RecyclerView.Adapter<AdapterRecView.ListViewHolder>() {
        override fun onCreateViewHolder(
                parent: ViewGroup,
                viewType: Int
        ): ListViewHolder {
                val binding = ItemRecyclerBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                )
                return ListViewHolder(binding)
        }

        override fun onBindViewHolder(
                holder: ListViewHolder,
                position: Int
        ) {
                TODO("Not yet implemented")
        }

        override fun getItemCount(): Int {
                TODO("Not yet implemented")
        }

        class ListViewHolder(val binding: ItemRecyclerBinding) :
                RecyclerView.ViewHolder(binding.root)
}