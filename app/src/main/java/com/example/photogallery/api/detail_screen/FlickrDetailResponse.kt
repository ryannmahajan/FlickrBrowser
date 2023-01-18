package com.example.photogallery.api.detail_screen

import com.example.photogallery.model.PhotoDetails
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FlickrDetailResponse (
    val sizes: FlickrSizes
)

@JsonClass(generateAdapter = true)
data class FlickrSizes(
    val size: List<PhotoDetails>
)
