package com.route.islamic40gsunwed.home.hadeth
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic40gsunwed.Constants
import com.route.islamic40gsunwed.base.BaseActivity
import com.route.islamic40gsunwed.databinding.HadethContentBinding
import com.route.islamic40gsunwed.home.quran.VersesAdapter


class HadethContentActivity:BaseActivity<HadethContentBinding>(){
     var title: String? = null
    lateinit var description: String
    lateinit var hadethAdapter: VersesAdapter
    lateinit var hadethRV: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding!!.root)
        back()
        initDate()
        binding!!.titleHadeth.text = title
        init()
        hadethRV.adapter = hadethAdapter

    }

    override fun initViewBinding(): HadethContentBinding = HadethContentBinding.inflate(layoutInflater)
    fun initDate(){
        title = intent.getStringExtra(Constants.TITLE_HADETH)
        description = intent.getStringExtra(Constants.Description_HADETH).toString()
    }
    fun init(){
        hadethRV = binding!!.contentRv
        hadethAdapter = VersesAdapter(description.split("\n"))
    }
    fun back(){
        binding!!.iconBack.setOnClickListener{
            finish()
        }

    }
    }
