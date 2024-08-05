package com.route.islamic40gsunwed.home.quran

import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic40gsunwed.Constants
import com.route.islamic40gsunwed.base.BaseActivity
import com.route.islamic40gsunwed.databinding.ChapterContentBinding

class ChapterContentActivity:BaseActivity<ChapterContentBinding>() {
    var chapterName: String? = null
    var chapterPosition: Int? = null
    lateinit var versesRV: RecyclerView
    lateinit var versesAdapter: VersesAdapter
    lateinit var versesList: List<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding!!.root)
        back()
        initParams()
        binding!!.titleText.text = chapterName
        initViews()
        versesRV.adapter = versesAdapter
    }

    override fun initViewBinding(): ChapterContentBinding =
        ChapterContentBinding.inflate(layoutInflater)

    fun initParams() {
        chapterName = intent.getStringExtra(Constants.CHAPTER_NAME)
        chapterPosition = intent.getIntExtra(Constants.CHAPTER_POSITION, -1)
    }

    fun readVersesFromFile() {
        var allFileCOntent = assets.open("${chapterPosition}.txt").bufferedReader().use {
            it.readText()
        }
        versesList = allFileCOntent.trim().split("\n")

    }

    fun initViews() {
        versesRV = binding!!.contentRv
        readVersesFromFile()
        versesAdapter = VersesAdapter(versesList)
    }

    fun back() {
        binding!!.iconBack.setOnClickListener {
            finish()
        }
    }
}
