package com.route.islamic40gsunwed.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islamic40gsunwed.R
import com.route.islamic40gsunwed.databinding.FragmentTasbeehBinding

class TasbeehFragment : Fragment() {

    var counter = 0
    var currentIndex = 0
    lateinit var azkarList: MutableList<String>
    lateinit var binding: FragmentTasbeehBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTasbeehBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        azkarList = resources.getStringArray(R.array.azkarList).toMutableList()
        binding.zkrTv.text = azkarList[0]
        onSeebhaClick()
    }

    private fun onSeebhaClick() {

        binding.seebhaBody.setOnClickListener {
            binding.seebhaBody.animate()
                .rotationBy((360 / 33).toFloat())
                .setDuration(300)
                .start()
            if (counter < 33)
                counter++
            else {
                counter = 0
                currentIndex = if (currentIndex < azkarList.size - 1) ++currentIndex else 0
                binding.zkrTv.text = azkarList[currentIndex]
            }
            binding.tasbeehCounterTv.text = counter.toString()

        }

    }
}