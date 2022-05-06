package com.runkeeper.clothingcase.feature.home.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.runkeeper.clothingcase.feature.home.domain.model.ClothingModel
import com.runkeeper.clothingcase.feature.home.presentation.databinding.RowSectionClothingBinding

class SectionClothingAdapter :
    ListAdapter<ClothingModel, SectionClothingAdapter.ClothingViewHolder>(DiffCallback()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ClothingViewHolder {
        val binding =
            RowSectionClothingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ClothingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ClothingViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class ClothingViewHolder(private val binding: RowSectionClothingBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(model: ClothingModel) {
            binding.model = model
            binding.executePendingBindings()

            initClothingAdapter(model)
        }

        private fun initClothingAdapter(model: ClothingModel) {
            val clothingAdapter = ClothingAdapter()
            clothingAdapter.submitList(model.records)
            binding.recyclerViewClothing.adapter = clothingAdapter
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<ClothingModel>() {

        override fun areItemsTheSame(oldItem: ClothingModel, newItem: ClothingModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ClothingModel, newItem: ClothingModel) =
            oldItem == newItem

    }
}