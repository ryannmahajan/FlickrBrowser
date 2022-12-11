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
    val galleryItems: StateFlow<List<GalleryItem>>
        get() = privateGalleryItems.asStateFlow()

    private val photoRepository = PhotoRepository()

    init {
        viewModelScope.launch {
            try {
                val response = PhotoRepository().fetchPhotos()
                Log.d(TAG, "Response received: $response")
                privateGalleryItems.value = response
            } catch (ex: Exception) {
                Log.e(TAG, "Failed to fetch gallery items", ex)
            }
        }
    }

}