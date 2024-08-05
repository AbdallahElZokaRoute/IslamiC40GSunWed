package com.route.islamic40gsunwed.home.quran

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic40gsunwed.Constants
import com.route.islamic40gsunwed.R

class QuranFragment:Fragment() {
    lateinit var chapterAdapter: ChapterNamesAdapter
    lateinit var chapterRv: RecyclerView
    lateinit var chapterList: ArrayList<Chapter>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quran, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        chapterRv = view.findViewById(R.id.chapters_rv)
        initData()
        chapterAdapter = ChapterNamesAdapter(chapterList)
        chapterAdapter.chapterOnClick = object: SetOnChapterClickListner{
            override fun onClick(chapter: Chapter) {
                var intent = Intent(requireActivity(), ChapterContentActivity::class.java)
                intent.putExtra(Constants.CHAPTER_NAME, chapter.name)
                intent.putExtra(Constants.CHAPTER_POSITION,chapter.position)
                startActivity(intent)
            }

        }
        chapterRv.adapter = chapterAdapter

    }
    fun initData(){
        chapterList = arrayListOf()
        Constants.ArSuras.forEachIndexed{ index, item ->
            run {
                chapterList.add(Chapter(item, index + 1))
            }

        }
    }
}