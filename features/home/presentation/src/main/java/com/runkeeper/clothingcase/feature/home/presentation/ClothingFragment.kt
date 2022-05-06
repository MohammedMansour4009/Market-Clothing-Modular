package com.runkeeper.clothingcase.feature.home.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.runkeeper.clothingcase.feature.home.presentation.adapter.SectionClothingAdapter
import com.runkeeper.clothingcase.feature.home.presentation.databinding.FragmentClothingBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ClothingFragment : Fragment() {

    private val clothingViewModel: ClothingViewModel by viewModels()

    private lateinit var binding: FragmentClothingBinding

    private lateinit var adapter: SectionClothingAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentClothingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        initObservers()
    }

    private fun initAdapter() {
        adapter = SectionClothingAdapter()
        binding.recyclerViewClothing.adapter = adapter
    }

    private fun initObservers() {

        progressObservers()

        successDataObservers()
    }

    private fun successDataObservers() {
        lifecycleScope.launch {
            clothingViewModel.successClothingStateFlow.collect { clothing ->
                adapter.submitList(clothing)
            }
        }
    }

    private fun progressObservers() {
        lifecycleScope.launch {
            clothingViewModel.loadingStateFlow.collect { isShow ->
                binding.progressBar.isVisible = isShow
            }
        }
    }
}