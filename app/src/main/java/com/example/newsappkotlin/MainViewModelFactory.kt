package com.example.newsappkotlin

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory(application: Application, private val postsRepository: PostRepository) :
    ViewModelProvider.AndroidViewModelFactory(application) {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass == MainViewModel::class.java) {
            return MainViewModel(postsRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}