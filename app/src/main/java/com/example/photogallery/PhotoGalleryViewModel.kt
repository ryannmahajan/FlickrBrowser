package com.example.photogallery

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

private const val TAG = "PhotoGalleryViewModel"

class PhotoGalleryViewModel: ViewModel() {
    private val privateGalleryItems = MutableStateFlow(listOf<GalleryItem>())
    val galleryItems
        get() = privateGalleryItems.asStateFlow()

    private var privateSearchQuery = MutableStateFlow("")
    val searchQuery
        get() = privateSearchQuery.asStateFlow()

    private val photoRepository = PhotoRepository()

    init {
        viewModelScope.launch {
            fetchPhotos()
        }
    }

    private suspend fun fetchPhotos(query: String? = null) {
        try {
            val response = query?.let { photoRepository.searchPhotos(it) } ?: photoRepository.fetchPhotos()
            Log.d(TAG, "Response received: $response")
            privateGalleryItems.value = response
        } catch (ex: Exception) {
            Log.e(TAG, "Failed to fetch gallery items", ex)
        }
    }

    fun submitQuery(query:String) {
        privateSearchQuery.value = query
        viewModelScope.launch {
            fetchPhotos(query)
        }
    }

}