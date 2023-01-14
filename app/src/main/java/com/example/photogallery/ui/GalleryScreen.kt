package com.example.photogallery.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.photogallery.PhotoGalleryViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.photogallery.GalleryItem

@Preview
@Composable
fun GalleryScreen(viewModel: PhotoGalleryViewModel = viewModel()) {
    val galleryItemsState = viewModel.galleryItems.collectAsState()
    val queryState = viewModel.searchQuery.collectAsState()

    Column {
//        SearchView(queryState.value, onQueryChange = {
//            // TODO: get pics from viewmodel
//        })
        PhotoGrid(galleryItemsState.value)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchView(query:String, onQueryChange:(String)->Unit) {
    TextField(
        value = query,
        onValueChange = {v -> onQueryChange(v)},
        modifier = Modifier.fillMaxWidth(),
        textStyle = TextStyle(color = Color.White, fontSize = 18.sp),
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = "",
                modifier = Modifier
                    .padding(15.dp)
                    .size(24.dp)
            )
        },
        trailingIcon = {
            if (query != "") {
                IconButton(
                    onClick = {
                        TODO("What to do on clear")
                    }
                ) {
                    Icon(
                        Icons.Default.Close,
                        contentDescription = "",
                        modifier = Modifier
                            .padding(15.dp)
                            .size(24.dp)
                    )
                }
            }
        },
        singleLine = true,
        shape = RectangleShape, // The TextFiled has rounded corners top left and right by default
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            cursorColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
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
