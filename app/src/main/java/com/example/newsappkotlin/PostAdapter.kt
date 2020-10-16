package com.example.newsappkotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(
    private val inflater: LayoutInflater,
    var posts: ArrayList<Post>
) : RecyclerView.Adapter<PostViewHolder>() {

    override fun getItemCount(): Int = posts.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val item = posts[position]
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            inflater.inflate(
                R.layout.post_item,
                parent,
                false
            )
        )
    }
}