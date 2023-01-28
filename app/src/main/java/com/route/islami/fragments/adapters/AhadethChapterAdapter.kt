package com.route.islami.fragments.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.route.islami.HadethData
import com.route.islami.R

class AhadethChapterAdapter(val chapters: MutableList<HadethData>) :Adapter<AhadethChapterAdapter.AhadethChapterViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AhadethChapterViewHolder {
        val view:View=LayoutInflater.from(parent.context).inflate(R.layout.ahadeth_item,parent,false)
        return AhadethChapterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return chapters.size
    }

    override fun onBindViewHolder(holder: AhadethChapterViewHolder, position: Int) {
        holder.hadethName.text= chapters[position].title

    }

    class AhadethChapterViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val hadethName:TextView=itemView.findViewById(R.id.hadeth_name_tv)
        val sepretor:View=itemView.findViewById(R.id.devidor)

    }

}