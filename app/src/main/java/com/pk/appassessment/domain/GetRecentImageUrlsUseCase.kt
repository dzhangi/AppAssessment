package com.pk.appassessment.domain

import com.pk.appassessment.data.remote.RecentImagesApi
import javax.inject.Inject

class GetRecentImageUrlsUseCase @Inject constructor(
    private val recentImagesApi: RecentImagesApi
) {
    suspend operator fun invoke(): List<String> {
        return recentImagesApi.getRecentPhotos().photos.photo
            .map { "https://live.staticflickr.com/${it.server}/${it.id}_${it.secret}_b.jpg" }
            .subList(0, 20)
    }
}