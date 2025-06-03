package com.example.mytvapplication.ui.screens.main.tv

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.tv.material3.Button
import androidx.tv.material3.Text
import com.example.mytvapplication.data.model.Channel
import com.example.mytvapplication.data.model.ChannelGroup
import com.example.mytvapplication.data.model.Movie
import com.example.mytvapplication.data.repository.ApiRepositoryImpl
import com.example.mytvapplication.domain.usecase.GetChannelsUseCase
import com.example.mytvapplication.domain.usecase.GetGroupsUseCase
import com.example.mytvapplication.domain.usecase.GetLastMoviesUseCase
import com.example.mytvapplication.ui.components.ChannelCard
import com.example.mytvapplication.ui.components.ChannelGroupItemCard
import com.example.mytvapplication.ui.screens.Screens

@Composable
fun Channels2Screen(
//    rootNavController: NavController,
    navController: NavHostController
) {
    Log.wtf("test", "start Channels2Screen")
    val focusRequester = remember { FocusRequester() }

    var groupList by remember { mutableStateOf<List<ChannelGroup>>(emptyList()) }
    var channelsList by remember { mutableStateOf<List<Channel>>(emptyList()) }
    var focusedGroup by remember { mutableStateOf<ChannelGroup?>(null) }

    val apiRepository = ApiRepositoryImpl()
    val getGroupsUseCase = GetGroupsUseCase(apiRepository = apiRepository)
    val getChannelsUseCase = GetChannelsUseCase(apiRepository = apiRepository)

    LaunchedEffect(Unit) {
        channelsList = getChannelsUseCase.execute()
        groupList = getGroupsUseCase.execute()
    }

    LaunchedEffect(focusedGroup) {
        Log.wtf("test", "Channels2Screen LaunchedEffect() focusedGroup = ${focusedGroup?.name}")
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        LaunchedEffect(Unit) {
//            focusRequester.requestFocus()
        }
        Column(
        ) {
            Text(
                text = "Channels2Screen",
                color = Color.White
            )

            Row {
                LazyColumn (
                    modifier = Modifier
                        .widthIn(max = 300.dp)
                ) {
                    itemsIndexed(groupList) { index, group ->
                        ChannelGroupItemCard(
                            group = group,
//                            modifier = Modifier
//                                .focusRequester(if (index == 1) focusRequester else null)
//                                .focusRequester(focusRequester)
                            onFocus = {
//                                Log.wtf("test", "Channels2Screen ChannelGroupItemCard onFocus() ${group.name}")
                                focusedGroup = group
                            },
                            onClick = {
                                Log.wtf("test", "Channels2Screen ChannelGroupItemCard onClick() ${group.name}")
                            }
                        )
                    }
                }
                LazyColumn {
                    items(5) {
                        ChannelCard(
                            channel = Channel(
                                id = "1",
                                icon = "https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review/card.jpg",
                                name = "Channel_11",
                            )
                        )
                    }
                }
            }

//            Button(
//                onClick = {
////                    Log.wtf("test", "Channels2Screen Channel1 onClick()")
//                          },
//                modifier = Modifier
//                    .focusRequester(focusRequester)
//                    .onKeyEvent{
//                    if(
//                        it.type == KeyEventType.KeyDown &&
//                        it.key == Key.DirectionRight
//                    ) {
//                        Log.wtf("test", "Channel1 click RIGHT")
//                        navController.navigate(Screens.Main.TV.Programs.route)
//                        true
//                    } else {
//                        false
//                    }
//                }
//            ) {
//                Text(
//                    text = "Channel 1",
//                    color = Color.White
//                )
//            }
        }
    }
}

@Preview(
    device = "id:tv_1080p",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
fun Channels2ScreenPreview() {
    Channels2Screen(navController = rememberNavController())
}