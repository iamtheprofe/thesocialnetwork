package com.example.thesocialnetwork.feed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.thesocialnetwork.Post
import com.example.thesocialnetwork.PostType
import com.example.thesocialnetwork.databinding.ItemPostBinding
import com.example.thesocialnetwork.databinding.ItemPostImagePostBinding

class FeedAdapter(
    private val posts: List<Post> = emptyList()
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class TextPostViewHolder(private val binding: ItemPostBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(post: Post) {
            post.text?.let { text ->
                binding.post.text = text
            }
            post.creator?.user?.profilePicture?.let { profilePicture ->
                Glide.with(itemView.context)
                    .load(profilePicture)
                    .into(binding.profilePicture)
            }
            post.creator?.user?.fullName?.let { fullName ->
                binding.creator.text = fullName
            }
        }
    }

    class ImagePostViewHolder(private val binding: ItemPostImagePostBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(post: Post) {
            post.text?.let { text ->
                binding.post.text = text
            }
            post.creator?.user?.profilePicture?.let { profilePicture ->
                Glide.with(itemView.context)
                    .load(profilePicture)
                    .into(binding.profilePicture)
            }
            post.creator?.user?.fullName?.let { fullName ->
                binding.creator.text = fullName
            }
            post.image?.let { image ->
                Glide.with(itemView.context)
                    .load(image)
                    .into(binding.image)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == PostType.Text.ordinal) {
            val binding =
                ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return TextPostViewHolder(binding)
        } else if (viewType == PostType.Image.ordinal) {
            val binding =
                ItemPostImagePostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ImagePostViewHolder(binding)
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