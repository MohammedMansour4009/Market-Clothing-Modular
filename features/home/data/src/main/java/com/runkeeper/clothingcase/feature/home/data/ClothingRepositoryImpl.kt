package com.runkeeper.clothingcase.feature.home.data

import com.runkeeper.clothingcase.feature.home.data.mapper.ClothingMapper
import com.runkeeper.clothingcase.feature.home.data.remote.ClothingRemoteDataSource
import com.runkeeper.clothingcase.feature.home.domain.repository.ClothingRepository
import com.runkeeper.clothingcase.feature.home.domain.model.ClothingModel
import javax.inject.Inject

internal class ClothingRepositoryImpl @Inject constructor(
    private val clothingRemoteDataSource: ClothingRemoteDataSource,
    private val clothingMapper: ClothingMapper,
) : ClothingRepository {

    override suspend fun getClothing(): List<ClothingModel> {
        return clothingRemoteDataSource.getMadel().map { clothingMapper.map(it) }
    }
}