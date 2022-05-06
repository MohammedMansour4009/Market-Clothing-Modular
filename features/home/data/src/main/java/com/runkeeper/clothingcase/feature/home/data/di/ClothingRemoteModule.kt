package com.runkeeper.clothingcase.feature.home.data.di

import com.runkeeper.clothingcase.feature.home.data.remote.ClothingRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
internal object ClothingRemoteModule {


    @Provides
    fun provideClothingRemoteDataSource(retrofit: Retrofit): ClothingRemoteDataSource {
        return retrofit.create()
    }

}
