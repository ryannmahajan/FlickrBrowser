package com.example.photogallery.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.photogallery.R


@Preview
@Composable
fun GalleryScreen() {
    PhotoGrid()
}

@Composable
private fun PhotoGrid() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
    ) {
        items(count = 9) { index ->
            Image(
                painterResource(R.drawable.bill_up_close),
                contentDescription= "",
                contentScale = ContentScale.Crop,
                modifier= Modifier.fillMaxSize()
            )
        }
    }
}
