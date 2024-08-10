package com.route.islamic40gsunwed.home.hadeth

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.route.islamic40gsunwed.databinding.FragmentHadethBinding
import com.route.islamic40gsunwed.databinding.ItemAhadethBinding
import com.route.islamic40gsunwed.home.hadeth.Hadeth

class HadethContentAdapter(var hadethList: List<Hadeth>): Adapter<HadethContentAdapter.HadethViewHolder>(){
    var setOnHadethListner: SetOnHadethListner?=null
    class HadethViewHolder(var binding: ItemAhadethBinding): ViewHolder(binding.root){
        fun bind(item: Hadeth){
            binding.textItem.text = item.title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HadethViewHolder {
        return HadethViewHolder(ItemAhadethBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return hadethList.size
    }

    override fun onBindViewHolder(holder: HadethViewHolder, position: Int) {
        var hasethItem = hadethList.get(position)
        holder.bind(hasethItem)
        holder.binding.textItem.setOnClickListener{setOnHadethListner?.onHadethClick(hasethItem)}
    }
}