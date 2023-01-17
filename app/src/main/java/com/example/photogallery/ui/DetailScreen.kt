@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.photogallery.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.photogallery.R

@Preview
@Composable
fun DetailScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        ImageView(
            url = "https://live.staticflickr.com/65535/52626927212_a8f02bb74c_k_d.jpg",
            modifier = Modifier
                .align(Alignment.Center)
        )
        BottomBar(
            url = "https://live.staticflickr.com/65535/52626927212_a8f02bb74c_k_d.jpg",
            modifier = Modifier
                .align(Alignment.BottomCenter)
        )
    }
}



@Composable
private fun ImageView(url: String, modifier: Modifier = Modifier) {
    AsyncImage(
        model = url,
        contentDescription = "",
        contentScale = ContentScale.Fit,
        modifier = modifier
            .wrapContentSize(),
        alignment = Alignment.Center,
        placeholder = rememberAsyncImagePainter(model = R.drawable.ic_launcher_foreground)
    )
}

@Composable
private fun BottomBar(url: String, modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
            .wrapContentHeight()
            .fillMaxWidth()) {
        val mod  = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
        LikeAndCommentIconsOnly(mod)
        LikeAndCommentNumbers(url, mod)
    }
}

@Composable
fun LikeAndCommentIconsOnly(modifier: Modifier = Modifier) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceAround) {
        Image(painter = painterResource(id = R.drawable.like_for_light_theme), contentDescription = "",
            Modifier.defaultMinSize(8.dp, 8.dp))
        Image(painter = painterResource(id = R.drawable.comment_for_light_theme), contentDescription = "",
            Modifier.defaultMinSize(8.dp, 8.dp))
    }
}

@Composable
fun LikeAndCommentNumbers(url: String, modifier: Modifier = Modifier) {
    Row (modifier, horizontalArrangement = Arrangement.SpaceAround) {
        Text(text = "56", fontSize = 16.sp)
        Text(text = "90", fontSize = 16.sp)
    }
}


