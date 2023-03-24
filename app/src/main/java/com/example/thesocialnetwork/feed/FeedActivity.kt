package com.example.thesocialnetwork.feed

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.thesocialnetwork.Creator
import com.example.thesocialnetwork.Post
import com.example.thesocialnetwork.R
import com.example.thesocialnetwork.User

class FeedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = FeedAdapter()

        val posts = arrayListOf<Post>()
        (0..500).forEach {
            posts.add(
                Post(
                    id = it.toString(),
                    text = "Muri se la come ${it + 1} veces",
                    creator = Creator(
                        user = User(
                            fullName = "Daniel Garcia"
                        )
                    )
                )
            )
        }
        recyclerView.adapter = FeedAdapter(
            posts = posts
        )
    }
}