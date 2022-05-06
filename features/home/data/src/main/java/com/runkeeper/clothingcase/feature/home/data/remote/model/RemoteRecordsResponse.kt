package com.runkeeper.clothingcase.feature.home.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RemoteRecordsResponse(

    @Json(name = "id")
    val id: Int,

    @Json(name = "title")
    val title: String,

    @Json(name = "price")
    val price: String,

    @Json(name = "active")
    val active: Boolean,

    @Json(name = "image")
    val image: String,
)
