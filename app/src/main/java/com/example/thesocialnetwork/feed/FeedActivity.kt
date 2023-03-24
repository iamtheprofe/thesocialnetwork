package com.example.thesocialnetwork.feed

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.thesocialnetwork.*

class FeedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = FeedAdapter(
            posts = listOf(
                Post(
                    type = PostType.Image,
                    creator = Creator(user = User(fullName = "Daniel Garcia Alvarado", profilePicture ="https://picsum.photos/200")),
                    image = "https://dummyimage.com/300x200/000/fff",
                    text = "I REALLY LIKE DICK"
                ),
                Post(
                    type = PostType.Text,
                    text = "This is an example for post text",
                    creator = Creator(user = User(profilePicture = "https://picsum.photos/200", fullName = "Daniel Garcia Alvarado")),
                )
            )
        )
    }
}