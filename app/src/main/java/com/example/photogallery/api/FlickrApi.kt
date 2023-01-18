package com.example.photogallery.api

import com.example.photogallery.api.detail_screen.FlickrDetailResponse
import com.example.photogallery.api.main_screen.FlickrResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface FlickrApi {
    @GET("services/rest/?method=flickr.interestingness.getList")
    suspend fun fetchPhotos(): FlickrResponse

    @GET("services/rest?method=flickr.photos.search")
    suspend fun searchPhotos(@Query("text") query: String): FlickrResponse

    @GET("services/rest?method=flickr.photos.getSizes")
    suspend fun getSizes(@Query("photo_id") id:String): FlickrDetailResponse
}