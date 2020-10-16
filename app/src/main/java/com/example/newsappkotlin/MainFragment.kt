package com.example.newsappkotlin

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_main.*

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
        viewModel?.getPosts()
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
            ViewModelProvider(this, MainViewModelFactory(Application(), PostRepository())).get(MainViewModel::class.java)
        }

        viewModel?.posts?.observe(viewLifecycleOwner, Observer {
            adapter.posts = it
            adapter.notifyDataSetChanged()
        })

        viewModel?.isLoading?.observe(viewLifecycleOwner, Observer {isLoading ->
            if (isLoading) {
                loading_progressbar.visibility = View.VISIBLE
            } else {
                if (viewModel?.errorMessage?.value != null) {
                    Toast.makeText(context, viewModel?.errorMessage?.value, Toast.LENGTH_SHORT).show()
                } else {
                    loading_progressbar.visibility = View.GONE
                }
            }
        })
    }
}