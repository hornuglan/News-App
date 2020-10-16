package com.example.newsappkotlin

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.result.Result
import com.google.gson.Gson

class MainViewModel(
    private val postsRepository: PostRepository
) : ViewModel() {
    val isLoading = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String?>()

    val posts = MutableLiveData<ArrayList<Post>>()

    fun getPosts() {
        isLoading.value = true
        errorMessage.value = null

        postsRepository.loadData({
            posts.postValue(it.posts)
        }, {
            isLoading.postValue(false)
            errorMessage.postValue(it)
        })
    }
}