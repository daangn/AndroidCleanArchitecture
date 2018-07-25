package com.daangn.www.photosample.feature.photolist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.daangn.www.photosample.databinding.LayoutPhotoListItemBinding
import com.daangn.www.photosample.entities.PhotoModel


class PhotoListAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var photos: List<PhotoModel> = arrayListOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PhotoListItemViewHolder(LayoutPhotoListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int =  photos.size

    override fun getItemId(position: Int) = position.toLong()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PhotoListItemViewHolder).bind(photos[position])
    }

    internal inner class PhotoListItemViewHolder(private var binding: LayoutPhotoListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(photo: PhotoModel) {
            binding.photoModel = photo
        }
    }
}