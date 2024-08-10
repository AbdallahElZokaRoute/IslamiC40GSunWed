package com.route.islamic40gsunwed.home.tsbeeh

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.route.islamic40gsunwed.R
import com.route.islamic40gsunwed.home.tsbeeh.Tsbeh

class TsbehFragment: Fragment() {
    lateinit var clickedButton: Button
    lateinit var numberOfTsbeeh: TextView
    lateinit var image: ImageView
    lateinit var headImage: ImageView
    var tsbeh: Tsbeh = Tsbeh()
     override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tsbeh, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initParamters(view)
        clickedButton.setOnClickListener {
            imageRotation()
            tsbeh.incrementTsbeeh()
            numberOfTsbeeh.text = tsbeh.counter.toString()
            clickedButton.text =  tsbeh.getCurrentTsbeh()

        }
    }
    fun initParamters(view: View){
        clickedButton = view.findViewById(R.id.button_click)
        numberOfTsbeeh = view.findViewById(R.id.ev_number_tsbeh)
        image = view.findViewById(R.id.sebha)
        headImage = view.findViewById(R.id.sebha_head)
    }
    fun imageRotation(){
        image.rotation += 11

    }


}