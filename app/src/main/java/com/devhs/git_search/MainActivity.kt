package com.devhs.git_search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var imgURL =
        "https://avatars3.githubusercontent.com/u/48559454?s=460&u=a5ca89eef46c643ba9e49f7373c27ad2f27c90d3"
    private var itemList = arrayListOf<GitItemData>(
        GitItemData("repotitle1", "깃 레포 title", imgURL),
        GitItemData("repotitle2", "깃 레포 title", imgURL),
        GitItemData("repotitle3", "깃 레포 title", imgURL),
        GitItemData("repotitle4", "깃 레포 title", imgURL),
        GitItemData("repotitle5", "깃 레포 title", imgURL),
        GitItemData("repotitle6", "깃 레포 title", imgURL),
        GitItemData("repotitle7", "깃 레포 title", imgURL),
        GitItemData("repotitle8", "깃 레포 title", imgURL),
        GitItemData("repotitle1", "깃 레포 title", imgURL),
        GitItemData("repotitle2", "깃 레포 title", imgURL),
        GitItemData("repotitle3", "깃 레포 title", imgURL),
        GitItemData("repotitle4", "깃 레포 title", imgURL),
        GitItemData("repotitle5", "깃 레포 title", imgURL),
        GitItemData("repotitle6", "깃 레포 title", imgURL),
        GitItemData("repotitle7", "깃 레포 title", imgURL),
        GitItemData("repotitle8", "깃 레포 title", imgURL)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mAdapter = MainRvAdapter(this, itemList)
        list_recyclerView.adapter = mAdapter

        val lm = LinearLayoutManager(this)
        list_recyclerView.layoutManager = lm
        list_recyclerView.setHasFixedSize(true)
    }
}