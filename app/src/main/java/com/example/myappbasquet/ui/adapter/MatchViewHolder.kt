package com.example.myappbasquet.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.myappbasquet.data.remote.model.MatchesEntry
import com.example.myappbasquet.databinding.ItemMatchBinding

class MatchViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemMatchBinding.bind(view)

    fun bind(MatchesEntry: MatchesEntry) {
        binding.titleEquipos

    }

}