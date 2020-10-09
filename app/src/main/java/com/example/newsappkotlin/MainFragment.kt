package com.example.newsappkotlin

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainFragment : Fragment() {

    private lateinit var adapter: PostAdapter
    private var viewModel: MainViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_main, container, false)

        adapter = PostAdapter(
            LayoutInflater.from(activity),
            arrayListOf()
        )

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRecycler()
        initViewModel()
    }

    private fun initRecycler() {
        val recycler = view?.findViewById<RecyclerView>(R.id.posts_recycler_view)
        val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recycler?.layoutManager = layoutManager
        recycler?.adapter = adapter

        val itemDecoration = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        recycler?.addItemDecoration(itemDecoration)
    }

    private fun initViewModel() {
        viewModel = activity.let {
            ViewModelProvider(this, MainViewModelFactory(Application())).get(MainViewModel::class.java)
        }
    }
}