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
    lateinit var azkarList: MutableList<String>

    lateinit var binding: FragmentTasbeehBinding
    var currentIndex = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentTasbeehBinding.inflate(layoutInflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        azkarList = resources.getStringArray(R.array.azkarList).toMutableList()
        binding.tasbehatTxtView.text = azkarList[0]
        onSebhaClick()

    }

    private fun onSebhaClick() {

        binding.bodyOfSebha.setOnClickListener {

            binding.bodyOfSebha.rotation = (360 / 33).toFloat()
            if (counter < 33) {
                counter++
            } else {
                counter = 0
                currentIndex = if (currentIndex < azkarList.size - 1) ++currentIndex else 0

                binding.tasbehatTxtView.text = azkarList[currentIndex]
            }

            binding.counterOfTasbehat.text = counter.toString()
        }
    }
}