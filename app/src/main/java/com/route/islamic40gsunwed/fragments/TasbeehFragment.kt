package com.route.islamic40gsunwed.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.route.islamic40gsunwed.R

class TasbeehFragment : Fragment() {

    lateinit var sebhaImage:ImageView
    private var counter:Int =0
    lateinit var counterTextView: TextView
    lateinit var tasbehBtn:CardView
    lateinit var resetBtn:CardView
    lateinit var tasbehBtnName:TextView


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
        tasbehBtnName = view.findViewById(R.id.tasbeh_btn_name)
        counter = 0
        counterTextView.text = counter.toString()
        sebhaImage = view.findViewById(R.id.sebha_body)

        tasbehBtn.setOnClickListener{
            counter++
            rotateSebha()
            counterTextView.text=counter.toString()
            if(counter==33){
                tasbehBtnName.text="الحمدلله"
            }else if (counter==66){
                tasbehBtnName.text="الله اكبر"
            }else if(counter==99){
                tasbehBtnName.text = "سبحان الله"
                counter=0
            }
        }

        resetBtn.setOnClickListener{
            tasbehBtnName.text = "سبحان الله"
            counter = 0
            returnSebhaToItsPosition()
            counterTextView.text=counter.toString()
        }
    }
    fun rotateSebha() {
        sebhaImage.rotation += 11F
    }

    fun returnSebhaToItsPosition() {
        sebhaImage.rotation =0F
    }
}