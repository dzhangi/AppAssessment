package com.pk.appassessment.domain.model

import com.pk.appassessment.data.remote.model.PhotoDto

data class PhotoInfo(
    val id: String,
    val server: String,
    val secret: String,
)