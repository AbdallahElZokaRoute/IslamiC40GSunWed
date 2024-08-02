package com.route.islamic40gsunwed.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.route.islamic40gsunwed.R

class TasbeehFragment : Fragment() {

    private var counter:Int =0
    lateinit var counterTextView: TextView
    lateinit var tasbehBtn:CardView
    lateinit var resetBtn:CardView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tasbeeh, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        counterTextView = view.findViewById(R.id.tasbeh_counter_text)
        tasbehBtn = view.findViewById(R.id.tasbeh_btn)
        resetBtn = view.findViewById(R.id.tasbeh_reset)

        counter = 0
        counterTextView.text = counter.toString()

        tasbehBtn.setOnClickListener{
            counter++
            counterTextView.text=counter.toString()
        }

        resetBtn.setOnClickListener{
            counter = 0
            counterTextView.text=counter.toString()
        }

    }
}