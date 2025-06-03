package com.example.mytvapplication.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.Card
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Text
import coil.compose.AsyncImage
import com.example.mytvapplication.R
import com.example.mytvapplication.data.model.Channel
import com.example.mytvapplication.data.model.Movie

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun ChannelCard(
    channel: Channel,
    modifier: Modifier = Modifier,
    onClick: (Channel) -> Unit = {}
) {
    Card(
        onClick = { onClick(channel) },
        modifier = modifier
//            .widthIn(max = 260.dp)
            .heightIn(max = 120.dp)
            .aspectRatio(16f / 9f)
//            .background(Color.DarkGray)
            .padding(10.dp)
        ,
    ) {
        Box(
            contentAlignment = Alignment.BottomCenter
        ) {
            AsyncImage(
                model = channel.icon,
                contentDescription = channel.name,
                contentScale = ContentScale.FillWidth,
                placeholder = painterResource(id = R.drawable.nimona_small),
                modifier = modifier
                    .fillMaxSize()
                    .background(Color.DarkGray)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(Color.DarkGray.copy(alpha = 0.8f))
                ,
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = channel.name,
                    color = Color.White,
                    fontSize = 26.sp
                )
            }
        }
    }
}

@Preview
@Composable
fun ChannelCardPreview() {
    ChannelCard(
        channel = Channel(
            id = "1",
            icon = "https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review/card.jpg",
            name = "Channel_11",
        )
    )
}