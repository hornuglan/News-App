package com.example.newsappkotlin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val isLoading = MutableLiveData<Boolean>()

    val posts = MutableLiveData<ArrayList<Post>>()

    fun getPosts() {}
}