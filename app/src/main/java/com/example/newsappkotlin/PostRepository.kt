package com.example.newsappkotlin

import android.util.Log
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.Headers
import com.github.kittinunf.result.Result
import com.google.gson.Gson

data class PostsResponse(
    val posts: ArrayList<Post>
)

class PostRepository {
    fun loadData(onSuccess: (PostsResponse) -> Unit, onFailure: (String) -> Unit) {
        val url = "https://content.guardianapis.com/search?show-tags=contributor&api-key=${R.string.guardian_student_key}"

        Fuel.get(url)
            .header(Headers.CONTENT_TYPE, "application/json")
            .responseString{_, _, result ->
                when(result) {
                    is Result.Failure -> {
                        val e = result.getException()
                        Log.d("Request Error", "${e.message}")
                        onFailure("${e.message}")
                    }
                    is Result.Success -> {
                        val posts = Gson().fromJson(result.get(), PostsResponse::class.java)
                        onSuccess(posts)
                    }
                }
            }
    }
}