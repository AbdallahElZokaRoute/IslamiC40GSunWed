package com.example.islami.ui.home.tasbeh

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.route.islamic40gsunwed.databinding.FragmentTasbeehBinding

class TasbeehFragment : Fragment() {
    lateinit var binding : FragmentTasbeehBinding
    var count =0 ;
    var indix=0 ;
    var elAzkarList = listOf("سبحان الله" ,"الحمدلله","لااله الا الله" ,"الحمدلله") ;
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentTasbeehBinding.inflate(inflater , container , false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        AzkarListview();
        onclicksebha()
    }

    private fun onclicksebha() {
        binding.tasbehImg.setOnClickListener{
            binding.tasbehImg.rotation = (360/33).toFloat()
            if (count<33){
                count++
                binding.tasbehImg.rotation=(360/33).toFloat()}
            else{
                count=0
                indix = if (indix<elAzkarList.size-1) ++ indix else 0
                binding.tasbeh.text =elAzkarList[indix]
                binding.tasbehImg.rotation=(360/10).toFloat()
            }
            binding.counterTv.text = count.toString()
        }
    }

    private fun AzkarListview() {
        binding.tasbeh.text=elAzkarList[0]
    }

}

