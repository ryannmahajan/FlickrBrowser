package com.example.photogallery.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.photogallery.PhotoGalleryViewModel

@Preview
@Composable
fun DetailScreen(viewModel: PhotoGalleryViewModel = viewModel()) {
    ImageView(url = "https://live.staticflickr.com/65535/52626927212_a8f02bb74c_k_d.jpg")
}

@Composable
private fun ImageView(url: String, modifier: Modifier = Modifier) {
    AsyncImage(
        model = url,
        contentDescription = "",
        contentScale = ContentScale.Fit,
        modifier = modifier
            .fillMaxSize(),
        alignment = Alignment.Center
    )
}