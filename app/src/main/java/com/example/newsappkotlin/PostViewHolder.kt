package com.example.newsappkotlin

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var category = itemView.findViewById<TextView>(R.id.post_category)
    private var date = itemView.findViewById<TextView>(R.id.post_date)
    private var author = itemView.findViewById<TextView>(R.id.post_author)
    private var title = itemView.findViewById<TextView>(R.id.post_title)

    fun bind(item: Post) {
        category.text = item.sectionName
        date.text = item.date
        author.text = "${item.authorFirstName} ${item.authorLastName}"
        title.text = item.title
    }
}