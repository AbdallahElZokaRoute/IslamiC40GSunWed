package com.route.islamic40gsunwed.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islamic40gsunwed.Constants
import com.route.islamic40gsunwed.R
import com.route.islamic40gsunwed.databinding.FragmentTasbeehBinding

class TasbeehFragment : Fragment() {

    lateinit var binding: FragmentTasbeehBinding
    var currentIndex = 0
    var counter: Int = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTasbeehBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


            onSebhaClick()




    }

    private fun onSebhaClick() {
        binding.ivSebhaBody.setOnClickListener {
            if(counter < 33)
            {
                binding.ivSebhaBody.rotation += (360/33).toFloat()
                counter++;

            }
            else
            {
                counter = 0
                currentIndex = (++currentIndex) % (Constants.azkarList.size)
                binding.btnSubhanaAllah.text = Constants.azkarList[currentIndex]
            }
            binding.tvNumberOfTassbeh.text= counter.toString()
        }
    }
}