package com.runkeeper.clothingcase.feature.home.domain.repository

import com.runkeeper.clothingcase.feature.home.domain.model.ClothingModel

interface ClothingRepository {

    suspend fun getClothing(): List<ClothingModel>

}