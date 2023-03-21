package com.example.thesocialnetwork.feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.thesocialnetwork.Post
import com.example.thesocialnetwork.PostType
import com.example.thesocialnetwork.R


class FeedAdapter   (
    private val posts: List<Post> = emptyList()
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    class TextViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textView = view.findViewById<TextView>(R.id.textView)

        fun bind(post: Post) {
            post.text?.let { text ->
                textView.text = text
            }
        }
    }

    class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageView = view.findViewById<ImageView>(R.id.imageView)

        fun bind(post: Post) {
            post.image?.let { image ->
                imageView.setImageResource(image)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == PostType.Text.ordinal) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_post_text, parent, false)
            return TextViewHolder(view)
        } else if (viewType == PostType.Image.ordinal) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_post_image, parent, false)
            return ImageViewHolder(view)
        }
        throw RuntimeException("ViewType $viewType does not have a ViewHolder created")
    }

    override fun getItemViewType(position: Int): Int {
        return posts[position].type.ordinal
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is TextViewHolder) {
            holder.bind(posts[position])
        } else if (holder is ImageViewHolder) {
            holder.bind(posts[position])
        }
    }
}

