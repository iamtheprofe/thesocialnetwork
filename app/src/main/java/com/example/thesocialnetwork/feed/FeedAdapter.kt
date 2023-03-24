package com.example.thesocialnetwork.feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.thesocialnetwork.Post
import com.example.thesocialnetwork.R

class FeedAdapter(
  private val posts:List<Post>
) :RecyclerView.Adapter<FeedAdapter.PostViewHolderText>(){
    class PostViewHolderText(view: View): RecyclerView.ViewHolder(view) {

    }
// CreateViewHolder sirve para llenar la vista reciclada con los datos del post
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolderText {
// Para crear la vista de view holder usamos la clas layoutinflater() predeterminada

    val view =LayoutInflater.from(parent.context).inflate(R.layout.item_text_post, parent, false)
    return PostViewHolderText(view)
    }

    override fun getItemCount(): Int {
        return posts.size

    }

    override fun onBindViewHolder(holder: PostViewHolderText, position: Int) {
        TODO("Not yet implemented")
    }
}