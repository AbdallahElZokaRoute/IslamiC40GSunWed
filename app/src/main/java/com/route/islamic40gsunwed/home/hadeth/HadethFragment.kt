package com.route.islamic40gsunwed.home.hadeth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic40gsunwed.Constants
import com.route.islamic40gsunwed.R

class HadethFragment:Fragment() {
    lateinit var hadethRV: RecyclerView
    lateinit var hadethList: MutableList<Hadeth>
    lateinit var hadethAdapter:HadethContentAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hadeth,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        hadethAdapter.setOnHadethListner = object :SetOnHadethListner{
            override fun onHadethClick(hadeth: Hadeth) {
                var intent = Intent(requireActivity(), HadethContentActivity::class.java)
                intent.putExtra(Constants.TITLE_HADETH,hadeth.title)
                intent.putExtra(Constants.Description_HADETH, hadeth.description)
                startActivity(intent)
            }
        }
    }

    private fun initViews(view: View) {
        hadethRV = view.findViewById(R.id.ahadeth_rv)
        initDate()
        hadethAdapter = HadethContentAdapter(hadethList)
        hadethRV.adapter = hadethAdapter

    }

    private fun initDate() {
        var allFileContent = requireActivity().assets.open("ahadeth.txt").bufferedReader().use {
            it.readText()
        }
        var allHadethList = allFileContent.split("#")
        hadethList = mutableListOf()

        allHadethList.forEach { hadeth ->
            run {
                var splittedHadeth = hadeth.trim().split("\n")
                hadethList.add(Hadeth(splittedHadeth.get(0),splittedHadeth.subList(1,splittedHadeth.size).joinToString()))
            }
        }

    }
}