package com.example.thesocialnetwork.feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.thesocialnetwork.Post
import com.example.thesocialnetwork.PostType
import com.example.thesocialnetwork.R

class FeedAdapter(
    private val posts: List<Post> = emptyList()
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class TextPostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val profilePictureImage = view.findViewById<ImageView>(R.id.profilePicture)
        private val postTextView = view.findViewById<TextView>(R.id.post)
        private val creatorTextView = view.findViewById<TextView>(R.id.creator)

        fun bind(post: Post) {
            post.text?.let { text ->
                postTextView.text = text
            }
            post.creator?.user?.profilePicture?.let { profilePicture ->
                Glide.with(itemView.context)
                    .load(profilePicture)
                    .into(profilePictureImage)
            }
            post.creator?.user?.fullName?.let { fullName ->
                creatorTextView.text = fullName
            }
        }
    }

    class ImagePostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val profilePictureImage = view.findViewById<ImageView>(R.id.profilePicture)
        private val postTextView = view.findViewById<TextView>(R.id.post)
        private val postImage = view.findViewById<ImageView>(R.id.image)
        private val creatorTextView = view.findViewById<TextView>(R.id.creator)


        fun bind(post: Post) {
            post.text?.let { text ->
                postTextView.text = text
            }
            post.creator?.user?.profilePicture?.let { profilePicture ->
                Glide.with(itemView.context)
                    .load(profilePicture)
                    .into(profilePictureImage)
            }
            post.creator?.user?.fullName?.let { fullName ->
                creatorTextView.text = fullName
            }
            post.image?.let { image ->
                Glide.with(itemView.context)
                    .load(image)
                    .into(postImage)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == PostType.Text.ordinal) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
            return TextPostViewHolder(view)
        } else if (viewType == PostType.Image.ordinal) {
            val view =
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_post_image_post, parent, false)
            return ImagePostViewHolder(view)
        }
        throw java.lang.RuntimeException("ViewType $viewType does not have a  ViewHolder created")
    }

    override fun getItemViewType(position: Int): Int {
        return posts[position].type.ordinal
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val post = posts[position]
        if (holder is TextPostViewHolder) {
            holder.bind(post)
        } else if (holder is ImagePostViewHolder) {
            holder.bind(post)
        }
    }
}