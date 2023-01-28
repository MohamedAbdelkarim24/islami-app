package com.route.islami.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.route.islami.ALHAMDULLAH
import com.route.islami.ALLAHAKBAR
import com.route.islami.R
import com.route.islami.SUBHANALLAH


class TasbeehFragment : Fragment() {
    lateinit var image:ImageView
    lateinit var tasbehWord:TextView
    lateinit var tasbehCounter:TextView
    var counter:Int=0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tasbeeh, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        image=view.findViewById(R.id.sebhaa_body)
        tasbehWord=view.findViewById(R.id.tasbeh_word)
        tasbehCounter=view.findViewById(R.id.tasbeh_counter)
        tasbehCounter.text="$counter"
        image.setOnClickListener{
            onSebhaClick()
        }

    }

    private fun onSebhaClick() {
        image.rotation=image.rotation+5
        counter++
        tasbehCounter.text="$counter"
        if (counter==33)
            if (tasbehWord.text==SUBHANALLAH){
                tasbehWord.text= ALHAMDULLAH
                counter=0
                tasbehCounter.text="$counter"
            }else if (tasbehWord.text== ALHAMDULLAH){
                tasbehWord.text= ALLAHAKBAR
                counter=0
                tasbehCounter.text="$counter"
            }else if (tasbehWord.text== ALLAHAKBAR) {
                tasbehWord.text = SUBHANALLAH
                counter = 0
                tasbehCounter.text = "$counter"
            }

    }
}