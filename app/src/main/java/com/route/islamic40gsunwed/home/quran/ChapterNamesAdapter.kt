package com.route.islamic40gsunwed.home.quran

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.route.islamic40gsunwed.databinding.ItemChapterNameBinding

class ChapterNamesAdapter(val chapters:ArrayList<Chapter>):Adapter<ChapterNamesAdapter.ChapterNameViewHolder>() {
    var chapterOnClick: SetOnChapterClickListner? = null
    class ChapterNameViewHolder(val itemChapterNameBinding: ItemChapterNameBinding):ViewHolder(itemChapterNameBinding.root){
        fun bind(chapter: Chapter) {
            itemChapterNameBinding.textName.text = chapter.name
            itemChapterNameBinding.textNumber.text = chapter.position.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChapterNameViewHolder {
        return ChapterNameViewHolder(ItemChapterNameBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return chapters.size
    }

    override fun onBindViewHolder(holder: ChapterNameViewHolder, position: Int) {
        var chapter = chapters[position]
        holder.bind(chapter)
        holder.itemChapterNameBinding.textName.setOnClickListener{ chapterOnClick?.onClick(chapter)}

    }

}