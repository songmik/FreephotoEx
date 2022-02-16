package com.example.a22_freephoto

import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.a22_freephoto.data.models.PhotoResponse
import com.example.a22_freephoto.databinding.ItemPhotoBinding

class PhotoAdapter: RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {

    val photos: List<PhotoResponse> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemPhotoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind((photos[position]))
    }

    override fun getItemCount(): Int = photos.size

    class  ViewHolder(
        private val binding: ItemPhotoBinding
    ): RecyclerView.ViewHolder(binding.root){

        fun bind(photo: PhotoResponse){
            Glide.with(binding.root)
                .load(photo.urls?.regular)
                .into(binding.photoImageView)

            Glide.with(binding.root)
                .load(photo.user?.profileImageUrls?.small)
                .into(binding.profileImageView)

            if(photo.user?.name.isNullOrBlank()){
                binding.authorTextView.visibility = View.GONE
            } else {
                binding.authorTextView.text = photo.user?.name
            }
            binding.descriptionTextView.text = photo.description

        }

    }
}