package com.route.islami.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.route.islami.HadethData
import com.route.islami.R
import com.route.islami.fragments.adapters.AhadethChapterAdapter


class AhadeethFragment : Fragment() {

    var allAhadeth = mutableListOf<HadethData>()
    var number=1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ahadeeth, container, false)
    }

    lateinit var ahadethRecyclerView: RecyclerView
    lateinit var adapter: AhadethChapterAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ahadethRecyclerView = view.findViewById(R.id.ahadeth_recycler_view)

        readHadethFile()
        adapter = AhadethChapterAdapter(allAhadeth)

        ahadethRecyclerView.adapter = adapter
    }

    private fun readHadethFile(){

       val reader:String?=activity?.assets?.open("ahadeth.txt")?.bufferedReader().use {
           it?.readText()
       }
        if (reader==null)return
        val hadethContent=reader.trim().split("#")
        hadethContent.forEach{
            val title=it.trim().substringBefore('\n')
            val content=it.trim().substringAfter('\n')
            allAhadeth.add(HadethData(title,content))
        }

    }
}