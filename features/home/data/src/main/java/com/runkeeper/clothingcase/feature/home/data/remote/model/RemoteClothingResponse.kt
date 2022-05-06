package com.runkeeper.clothingcase.feature.home.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RemoteClothingResponse(

    @Json(name = "id")
    var id: Int,

    @Json(name = "title")
    var title: String,

    @Json(name = "label")
    var label: String,

    @Json(name = "items")
    var items: List<RemoteRecordsResponse>,
)