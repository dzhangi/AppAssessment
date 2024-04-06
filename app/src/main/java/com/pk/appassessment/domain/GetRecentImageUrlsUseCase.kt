package com.pk.appassessment.domain

import com.pk.appassessment.domain.repo.RecentImagesRepo
import javax.inject.Inject

class GetRecentImageUrlsUseCase @Inject constructor(
    private val repo: RecentImagesRepo
) {
    suspend operator fun invoke(): List<String> {
        return repo.getRecentImages()
            .map { "https://live.staticflickr.com/${it.server}/${it.id}_${it.secret}_b.jpg" }
            .subList(0, 20)
    }
}