package com.runkeeper.clothingcase.feature.home.domain.model


data class RecordsModel(

    val id: Int,

    val title: String,

    val label: String,

    val active: Boolean,

    val image: String

) {
    var isFavorite = false
}