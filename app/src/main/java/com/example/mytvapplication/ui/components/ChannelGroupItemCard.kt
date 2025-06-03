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
import androidx.compose.ui.focus.onFocusChanged
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
import com.example.mytvapplication.data.model.ChannelGroup
import com.example.mytvapplication.data.model.Movie

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun ChannelGroupItemCard(
    group: ChannelGroup,
    modifier: Modifier = Modifier,
    onFocus: (ChannelGroup) -> Unit = {},
    onClick: (ChannelGroup) -> Unit = {}
) {
    Card(
        onClick = { onClick(group) },
        modifier = modifier
//            .widthIn(max = 260.dp)
            .height(60.dp)
//            .aspectRatio(16f / 9f)
//            .background(Color.DarkGray)
            .padding(10.dp)
            .onFocusChanged { if (it.isFocused) onFocus(group) }
        ,
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(Color.DarkGray)
                .padding(5.dp)
            ,
            contentAlignment = Alignment.CenterStart
        ) {
                Text(
                    text = group.name,
                    color = Color.White,
                    fontSize = 26.sp
                )
        }
    }
}

@Preview
@Composable
fun ChannelGroupItemCardPreview() {
    ChannelGroupItemCard(
        group = ChannelGroup(
            id = "1",
            name = "Channel_11",
        )
    )
}