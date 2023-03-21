package com.example.thesocialnetwork.feed

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.thesocialnetwork.Post
import com.example.thesocialnetwork.PostType
import com.example.thesocialnetwork.R


class FeedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = FeedAdapter(
            posts = listOf(
                Post(type = PostType.Text, text = "Lord alvarado es una riata"),
                Post(type = PostType.Text, text = "El diegomaxter se rifo con 20k puntos de canal"),
                Post(type = PostType.Image, image = R.drawable.ic_google),
                Post(type = PostType.Text, text = "El shadow se la come y el kevin también"),
                Post(type = PostType.Image, image = R.drawable.ic_email),
            )
        )

        recyclerView.adapter = adapter
    }
}