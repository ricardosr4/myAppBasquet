package com.example.myappbasquet.ui.adapter

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.myappbasquet.R
import com.example.myappbasquet.data.remote.model.MatchesEntry
import com.example.myappbasquet.databinding.ItemMatchBinding

class MatchViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemMatchBinding.bind(view)

    @SuppressLint("SetTextI18n")
    fun bind(matchEntry: MatchesEntry,clickListener: (MatchesEntry, Int) -> Unit) {
        binding.titleEquipos.text = matchEntry.equipo_local + " vs " + matchEntry.equipo_visitante
        binding.titleEquipos.setOnClickListener { clickListener(matchEntry, R.id.titleEquipos) }
        binding.ivEquipoLocal.setOnClickListener { clickListener(matchEntry, R.id.ivEquipoLocal) }

    }

}