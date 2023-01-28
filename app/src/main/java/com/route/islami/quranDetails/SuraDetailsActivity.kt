package com.route.islami.quranDetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.route.islami.FILE_NAME
import com.route.islami.R
import com.route.islami.SURA_NAME

class SuraDetailsActivity : AppCompatActivity() {
    lateinit var suraContentRecyclerView: RecyclerView
    lateinit var adapter: SuraContentAdapter
    lateinit var suraList: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_details)

        suraContentRecyclerView = findViewById(R.id.sura_content_recycler_view)
        val suraName = intent.getStringExtra(SURA_NAME)
        val fileName = intent.getStringExtra(FILE_NAME)
        readFileText(fileName)

        adapter = SuraContentAdapter(suraList)

        suraContentRecyclerView.adapter = adapter

    }

    fun readFileText(fileName: String?) {
        val fileContent = assets.open(fileName!!).bufferedReader().use { it.readText() }
        val suraContent = fileContent.split('\n')
        suraList = suraContent;
    }
}