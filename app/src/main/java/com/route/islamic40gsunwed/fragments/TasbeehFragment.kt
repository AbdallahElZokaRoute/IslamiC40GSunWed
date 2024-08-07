package com.route.islamic40gsunwed.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.route.islamic40gsunwed.R
import com.route.islamic40gsunwed.databinding.FragmentTasbeehBinding

class TasbeehFragment : Fragment() {

    lateinit var binding: FragmentTasbeehBinding
    lateinit var tasbeehList: MutableList<String>
    var count = 0
    var currentIndex = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTasbeehBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tasbeehList = resources.getStringArray(R.array.tasbeeh_list).toMutableList()
        binding.tvTasbeehText.text = tasbeehList[0]
        onSebhaClick()
    }

    private fun onSebhaClick() {
        binding.tvTasbeehCounter.text = count.toString()
        binding.imvSebhaBody.setOnClickListener {
            var currentRotation = binding.imvSebhaBody.rotation
            currentRotation += (360/33).toFloat()
            binding.imvSebhaBody.rotation = currentRotation % 360
            if (count < 33) {
                count++
            } else {
                count = 0
                currentIndex = if (currentIndex < tasbeehList.size-1) ++currentIndex else 0
                binding.tvTasbeehText.text = tasbeehList[currentIndex]
            }
            binding.tvTasbeehCounter.text = count.toString()
        }
    }

}