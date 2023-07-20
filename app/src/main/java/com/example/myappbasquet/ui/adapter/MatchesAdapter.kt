package com.example.myappbasquet.ui.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myappbasquet.R
import com.example.myappbasquet.data.remote.model.MatchesEntry
import com.example.myappbasquet.databinding.ItemMatchBinding
import javax.inject.Singleton

class MatchesAdapter(
    private var list: MutableList<MatchesEntry>,
    // todo esto es nuevo es para el click
    private val clickListener: (MatchesEntry, Int) -> Unit
    ) : RecyclerView.Adapter<MatchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MatchViewHolder(layoutInflater.inflate(R.layout.item_match,parent,false))
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        // todo y se le pasa a la funcion bind en el viewholder al igual que la lista
        holder.bind(list[position],clickListener)
    }

}


