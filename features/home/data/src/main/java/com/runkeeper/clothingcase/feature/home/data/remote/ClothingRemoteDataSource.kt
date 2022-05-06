package com.runkeeper.clothingcase.feature.home.data.remote

import com.runkeeper.clothingcase.feature.home.data.remote.model.RemoteClothingResponse
import com.serjltt.moshi.adapters.Wrapped
import retrofit2.http.GET

internal interface ClothingRemoteDataSource{

    @GET("clothing")
    @Wrapped(path = ["data"])
    suspend fun getMadel(): List<RemoteClothingResponse>

}