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
import com.route.islamic40gsunwed.databinding.FragmentTsbehBinding
import com.route.islamic40gsunwed.home.tsbeeh.Tsbeh

class TsbehFragment: Fragment() {
    lateinit var binding: FragmentTsbehBinding
    var tsbeh: Tsbeh = Tsbeh()
     override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding = FragmentTsbehBinding.inflate(inflater,container,false)
         return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonClick.setOnClickListener {
            imageRotation()
            tsbeh.incrementTsbeeh()
            binding.evNumberTsbeh.text = tsbeh.counter.toString()
            binding.buttonClick.text =  tsbeh.getCurrentTsbeh()

        }
    }

    fun imageRotation(){
        binding.sebha.rotation += 360/33

    }


}