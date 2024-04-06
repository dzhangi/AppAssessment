package com.pk.appassessment.data.remote.model

data class PhotosDto(
    val page: Int,
    val pages: Int,
    val perpage: Int,
    val photo: List<PhotoDto>,
    val total: Int
)