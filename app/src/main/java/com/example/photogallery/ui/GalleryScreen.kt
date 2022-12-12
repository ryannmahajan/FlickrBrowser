package com.example.photogallery.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.photogallery.PhotoGalleryViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.photogallery.GalleryItem

@Preview
@Composable
fun GalleryScreen(viewModel: PhotoGalleryViewModel = viewModel()) {
    val galleryItemsState = viewModel.galleryItems.collectAsState()
    PhotoGrid(galleryItemsState.value)
}

@Composable
private fun PhotoGrid(galleryItems: List<GalleryItem>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier
    ) {
        items(count = galleryItems.size) { index ->
            ImageView(galleryItems[index].url)
        }
    }
}

@Composable
private fun ImageView(url: String, modifier: Modifier = Modifier) {
    AsyncImage(
        model = url,
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = modifier
            .fillMaxSize()
            .height(120.dp)
    )
}
