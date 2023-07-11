package com.example.myappbasquet.ui.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myappbasquet.R
import com.example.myappbasquet.data.remote.model.MatchesEntry


class MatchesAdapter(private val list: MutableList<MatchesEntry>) :
    RecyclerView.Adapter<MatchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MatchViewHolder(layoutInflater.inflate(R.layout.item_match,parent,false))
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        holder.bind(list[position])
    }
}

