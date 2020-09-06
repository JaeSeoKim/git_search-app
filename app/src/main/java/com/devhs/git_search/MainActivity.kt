package com.devhs.git_search

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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

        val mAdapter = MainRvAdapter(this, itemList) { item ->
            val intent = Intent(this, RepoViewerActivity::class.java)
            startActivity(intent)
        }
        list_recyclerView.adapter = mAdapter

        val lm = LinearLayoutManager(this)
        list_recyclerView.layoutManager = lm
        list_recyclerView.setHasFixedSize(true)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)
        val searchView: SearchView = menu.findItem(R.id.action_search).actionView as SearchView

        // Associate searchable configuration with the SearchView
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchView.apply {
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
        }


        searchView!!.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                Toast.makeText(this@MainActivity, "테스트 $query", Toast.LENGTH_SHORT).show()
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                return false
            }
        })

        return super.onCreateOptionsMenu(menu)
    }


}