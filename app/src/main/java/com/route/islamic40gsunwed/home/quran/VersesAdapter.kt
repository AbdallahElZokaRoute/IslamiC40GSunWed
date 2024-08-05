package com.route.islamic40gsunwed.home.quran

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.route.islamic40gsunwed.databinding.ItemVerseBinding

class VersesAdapter(var versesList: List<String>): Adapter<VersesAdapter.versesViewHolder>() {
    class versesViewHolder(var itemVerse: ItemVerseBinding): ViewHolder(itemVerse.root){
        fun bind(item: String, position: Int){
            itemVerse.textContent.text = "${item} (${position+1})"
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): versesViewHolder {
        return versesViewHolder(ItemVerseBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return versesList.size
    }

    override fun onBindViewHolder(holder: versesViewHolder, position: Int) {
        var versesItem = versesList.get(position)
        holder.bind(versesItem, position)
    }
}