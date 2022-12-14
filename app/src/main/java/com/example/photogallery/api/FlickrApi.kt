package com.example.photogallery.api

import retrofit2.http.GET

private const val API_KEY = "42c4ea9f822ef89d3cf775ff2cae194d"

interface FlickrApi {
    @GET(
        "services/rest/?method=flickr.interestingness.getList" +
                "&api_key=$API_KEY" +
                "&format=json" +
                "&nojsoncallback=1" +
                "&extras=url_s"
    )
    suspend fun fetchPhotos(): FlickrResponse
}