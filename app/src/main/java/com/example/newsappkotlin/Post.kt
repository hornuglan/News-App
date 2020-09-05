package com.example.newsappkotlin

data class Post(
    val sectionName: String,
    val date: String,
    val title: String,
    val url: String,
    val authorFirstName: String,
    val authorLastName: String
)
