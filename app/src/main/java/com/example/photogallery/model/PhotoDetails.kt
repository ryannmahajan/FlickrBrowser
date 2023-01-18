package com.example.photogallery.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PhotoDetails(
    val label:String,
    val width:Int, // todo: how to convert
    val height:Int,
    @Json(name="source") val url:String
)