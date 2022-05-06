package com.runkeeper.clothingcase.feature.home.data.di

import com.runkeeper.clothingcase.feature.home.data.ClothingRepositoryImpl
import com.runkeeper.clothingcase.feature.home.domain.repository.ClothingRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
internal interface ClothingFeatureModule {

    @Binds
    fun bindHomeRepository(impl: ClothingRepositoryImpl): ClothingRepository

}
