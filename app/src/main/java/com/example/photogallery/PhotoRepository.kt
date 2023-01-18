package com.example.photogallery

import com.example.photogallery.api.FlickrApi
import com.example.photogallery.api.PhotoInterceptor
import com.example.photogallery.model.GalleryItem
import com.example.photogallery.model.PhotoDetails
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

class PhotoRepository {
    val flickrApi: FlickrApi

    init {
        val httpClientWithInterception = OkHttpClient.Builder()
            .addInterceptor(PhotoInterceptor())
            .build()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.flickr.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(httpClientWithInterception)
            .build()
        flickrApi = retrofit.create<FlickrApi>()
    }

    suspend fun fetchPhotos(): List<GalleryItem> =
        flickrApi.fetchPhotos().photos.galleryItems

    suspend fun searchPhotos(query: String): List<GalleryItem> =
        flickrApi.searchPhotos(query).photos.galleryItems

    suspend fun getSizes(id:String): List<PhotoDetails> =
        flickrApi.getSizes(id).sizes.size
}
