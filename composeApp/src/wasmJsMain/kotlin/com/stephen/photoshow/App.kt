package com.stephen.photoshow

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource

import photoshow.composeapp.generated.resources.Res
import photoshow.composeapp.generated.resources.compose_multiplatform

@Composable
fun App() {
    MaterialTheme {
        val picAddrList = listOf(
            "/home/ubuntu/cmp_photo_show/pics/pic_grandma_and_baby",
            "/home/ubuntu/cmp_photo_show/pics/pic_kodak_rain_drop",
            "/home/ubuntu/cmp_photo_show/pics/pic_light_circle",
            "/home/ubuntu/cmp_photo_show/pics/pic_oldman_bike_car",
            "/home/ubuntu/cmp_photo_show/pics/pic_sunrise",
            "/home/ubuntu/cmp_photo_show/pics/pic_sunset",
        )

        LazyColumn {
            items(picAddrList) { picAddr ->
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalPlatformContext.current)
                            .data(File(iconFilePath))
                            .build(),
                        modifier = Modifier.padding(start = 5.dp).size(50.dp),
                        contentDescription = "photo",
                        onState = {
                            imageState.value = it
                        }
                    )
                    Text(text = picAddr)
                }
            }
        }

    }
}