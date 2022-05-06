package com.runkeeper.clothingcase.feature.home.domain.usecase

import com.runkeeper.clothingcase.feature.home.domain.model.ClothingModel
import com.runkeeper.clothingcase.feature.home.domain.repository.ClothingRepository
import javax.inject.Inject

class GetClothingUseCase @Inject constructor(
    private val clothingRepository: ClothingRepository
) {
    suspend operator fun invoke(): List<ClothingModel> {
        return clothingRepository.getClothing()
    }
}