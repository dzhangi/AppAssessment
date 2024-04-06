package com.pk.appassessment.data.remote.model

import com.pk.appassessment.domain.model.PhotoInfo

data class PhotoDto(
    val farm: Int,
    val id: String,
    val isfamily: Int,
    val isfriend: Int,
    val ispublic: Int,
    val owner: String,
    val secret: String,
    val server: String,
    val title: String
)

fun PhotoDto.toPhotoInfo(): PhotoInfo {
    return PhotoInfo(
        id = this.id,
        server = this.server,
        secret = this.secret,
    )
}