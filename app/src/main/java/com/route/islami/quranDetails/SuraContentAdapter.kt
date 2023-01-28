package com.route.islami.quranDetails

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.route.islami.R

class SuraContentAdapter(var suraContentLines: List<String>?) :
    Adapter<SuraContentAdapter.SuraContentViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuraContentViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.sura_content_item, parent, false)
        return SuraContentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return suraContentLines?.size ?: -1
    }

    override fun onBindViewHolder(holder: SuraContentViewHolder, position: Int) {
        holder.suraContentItem.text = suraContentLines?.get(position)
    }

    fun changeTextFile(suraContentLines: List<String>) {
        this.suraContentLines = suraContentLines
        notifyDataSetChanged()
    }

    class SuraContentViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {
        var suraContentItem: TextView = itemView.findViewById(R.id.sura_item_content)
    }
}