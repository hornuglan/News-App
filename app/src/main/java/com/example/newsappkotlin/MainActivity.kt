package com.example.newsappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val list = arrayListOf<Post>(
        Post("a", "b", "c", "d", "e", "f"),
        Post("a", "b", "c", "d", "e", "f"),
        Post("a", "b", "c", "d", "e", "f"),
        Post("a", "b", "c", "d", "e", "f"),
        Post("a", "b", "c", "d", "e", "f"),
        Post("a", "b", "c", "d", "e", "f"),
        Post("a", "b", "c", "d", "e", "f"),
        Post("a", "b", "c", "d", "e", "f")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecycler()
    }

    private fun initRecycler() {
        val recycler = findViewById<RecyclerView>(R.id.posts_recycler_view)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler.layoutManager = layoutManager
        recycler.adapter = PostAdapter(LayoutInflater.from(this), list)

        val itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recycler.addItemDecoration(itemDecoration)
    }
}
