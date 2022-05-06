package com.runkeeper.clothingcase.feature.home.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.runkeeper.clothingcase.feature.home.domain.model.RecordsModel
import com.runkeeper.clothingcase.feature.home.presentation.databinding.RowClothingBinding
import okhttp3.internal.notify


class ClothingAdapter : ListAdapter<RecordsModel, ClothingAdapter.ClothingViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClothingViewHolder {
        val binding =
            RowClothingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ClothingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ClothingViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ClothingViewHolder(private val binding: RowClothingBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: RecordsModel?) {
            binding.model = item

            binding.imageViewFavorite.setOnClickListener {
                item?.apply {
                    isFavorite = !isFavorite
                }
                notifyItemChanged(adapterPosition)
            }

        }


    }

    class DiffCallback : DiffUtil.ItemCallback<RecordsModel>() {

        override fun areItemsTheSame(oldItem: RecordsModel, newItem: RecordsModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: RecordsModel, newItem: RecordsModel) =
            oldItem == newItem

    }
}