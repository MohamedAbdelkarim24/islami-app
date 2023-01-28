package com.route.islami.fragments.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.route.islami.R
import com.route.islami.callBacks.OnSuraClickListener

class SurasNameAdapter(val suras: List<String>, val count:List<String>):Adapter<SurasNameAdapter.QuranItemViewHolder>() {

    var onSuraClickListener:OnSuraClickListener?=null
    class QuranItemViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var suraName:TextView=itemView.findViewById(R.id.name_of_sura)
        var numberOfAyat:TextView=itemView.findViewById(R.id.sura_count)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuranItemViewHolder {
        val view:View=LayoutInflater.from(parent.context).inflate(R.layout.quran_list_item,parent,false)
        return QuranItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return suras.size
    }

    override fun onBindViewHolder(holder: QuranItemViewHolder, position: Int) {
        holder.suraName.text=suras.get(position)
        holder.numberOfAyat.text=count.get(position)
        holder.itemView.setOnClickListener {
            onSuraClickListener?.onSuraClick(suras.get(position),position)
        }
    }
}