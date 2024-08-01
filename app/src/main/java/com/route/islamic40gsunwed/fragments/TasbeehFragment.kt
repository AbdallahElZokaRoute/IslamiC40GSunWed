package com.route.islamic40gsunwed.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islamic40gsunwed.R
import com.route.islamic40gsunwed.databinding.FragmentTasbeehBinding

class TasbeehFragment : Fragment() {

    lateinit var binding: FragmentTasbeehBinding
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
        binding.btnSubhanaAllah.setOnClickListener {
            counter++
            binding.tvNumberOfTassbeh.text = counter.toString()
        }
    }
}