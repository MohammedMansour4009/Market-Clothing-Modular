package com.runkeeper.clothingcase.feature.home.data.mapper

import com.runkeeper.clothingcase.feature.home.data.remote.model.RemoteClothingResponse
import com.runkeeper.clothingcase.feature.home.data.remote.model.RemoteRecordsResponse
import com.runkeeper.clothingcase.feature.home.domain.model.RecordsModel
import com.runkeeper.clothingcase.feature.home.domain.model.ClothingModel
import javax.inject.Inject

internal class ClothingMapper @Inject constructor() {

    fun map(remoteClothingResponse: RemoteClothingResponse): ClothingModel {
        return ClothingModel(
            id = remoteClothingResponse.id,
            title = remoteClothingResponse.title,
            label = remoteClothingResponse.label,
            records = remoteClothingResponse.items.map { mapRecords(it) },
        )
    }

    private fun mapRecords(remoteRecordsResponse: RemoteRecordsResponse): RecordsModel {
        return RecordsModel(
            id = remoteRecordsResponse.id,
            title = remoteRecordsResponse.title,
            label = remoteRecordsResponse.price,
            active = remoteRecordsResponse.active,
            image = remoteRecordsResponse.image
        )
    }

}