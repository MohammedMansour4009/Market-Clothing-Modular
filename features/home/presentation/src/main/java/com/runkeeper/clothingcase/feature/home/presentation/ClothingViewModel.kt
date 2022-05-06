package com.runkeeper.clothingcase.feature.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.runkeeper.clothingcase.feature.home.domain.usecase.GetClothingUseCase
import com.runkeeper.clothingcase.feature.home.domain.model.ClothingModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClothingViewModel @Inject constructor(private val getClothingUseCase: GetClothingUseCase) :
    ViewModel() {

    private var _loadingStateFlow = MutableStateFlow(false)
    var loadingStateFlow: MutableStateFlow<Boolean> = _loadingStateFlow

    private var _errorStateFlow = MutableStateFlow(Exception())
    var errorStateFlow: StateFlow<Exception> = _errorStateFlow

    private var _successClothingStateFlow = MutableStateFlow<List<ClothingModel>?>(null)
    var successClothingStateFlow: StateFlow<List<ClothingModel>?> = _successClothingStateFlow

    init {
        getClothing()
    }

    private fun getClothing() {
        viewModelScope.launch {
            _loadingStateFlow.emit(true)
            try {

                _successClothingStateFlow.emit(getClothingUseCase.invoke())

            } catch (e: Exception) {

                _errorStateFlow.emit(e)

            }
            _loadingStateFlow.emit(false)
        }
    }
}