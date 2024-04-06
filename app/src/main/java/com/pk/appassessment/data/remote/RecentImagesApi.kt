package com.pk.appassessment.data.remote

import com.pk.appassessment.data.remote.model.RecentImagesDto
import retrofit2.http.GET
import retrofit2.http.Query

interface RecentImagesApi {
    @GET("?method=flickr.photos.getRecent&format=json&nojsoncallback=1")
    suspend fun getRecentPhotos(
        @Query("api_key") apiKey: String = "da9d38d3dee82ec8dda8bb0763bf5d9c"
    ): RecentImagesDto
}