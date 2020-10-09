package com.example.newsappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.Headers
import com.github.kittinunf.result.Result
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, MainFragment())
            .commit()
    }

    private fun getPosts() {
        val url = "https://content.guardianapis.com/search?show-tags=contributor&api-key=${R.string.guardian_student_key}"

        Fuel.get(url)
            .responseString{_, _, result ->
                when(result) {
                    is Result.Failure -> {
                        val e = result.getException()
                        Log.d("Request error", "${e.message}")
                    }
                    is Result.Success -> {
                        val posts = Gson().fromJson(result.get(), Post::class.java)
                    }
                }
            }
    }
}
