package com.route.islami.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.route.islami.FILE_NAME
import com.route.islami.R
import com.route.islami.SURA_NAME
import com.route.islami.callBacks.OnSuraClickListener
import com.route.islami.fragments.adapters.SurasNameAdapter
import com.route.islami.model.ArSuras
import com.route.islami.model.numberOfAyat
import com.route.islami.quranDetails.SuraDetailsActivity


class QuranFragment : Fragment() {


    lateinit var quranRecyclerView: RecyclerView
     lateinit var quranAdapter:SurasNameAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quran, container, false)



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        quranRecyclerView= view.findViewById(R.id.quran_recycler_view)
        quranAdapter= SurasNameAdapter(ArSuras, numberOfAyat)
        quranRecyclerView.adapter=quranAdapter
        quranRecyclerView.layoutManager=LinearLayoutManager(context)
        quranAdapter.onSuraClickListener=object :OnSuraClickListener{

            override fun onSuraClick(suraName: String, position: Int) {
                val fileName="${position+1}.txt"
                val intent=Intent(activity,SuraDetailsActivity::class.java)
                intent.putExtra(FILE_NAME,"${position+1}.txt")
                intent.putExtra(SURA_NAME,suraName)
                startActivity(intent)
            }
        }
    }
}