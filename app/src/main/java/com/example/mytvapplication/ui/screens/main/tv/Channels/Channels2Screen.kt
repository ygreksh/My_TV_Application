package com.example.mytvapplication.ui.screens.main.tv.Channels

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.tv.material3.Text
import com.example.mytvapplication.data.network.ApiRemoteDataSourceImpl
import com.example.mytvapplication.data.repository.AppRepositoryImpl
import com.example.mytvapplication.data.storage.LocalDataSourceImpl
import com.example.mytvapplication.domain.model.Channel
import com.example.mytvapplication.domain.model.Group
import com.example.mytvapplication.domain.usecase.GetChannelsUseCase
import com.example.mytvapplication.domain.usecase.GetGroupsUseCase
import com.example.mytvapplication.ui.components.ChannelCard
import com.example.mytvapplication.ui.components.ChannelGroupItemCard
import com.example.mytvapplication.ui.screens.Screens
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun Channels2Screen(
//    rootNavController: NavController,
    navController: NavHostController,
    selectedGroupId: String,
    viewModel: ChannelsViewModel = hiltViewModel()
) {
    Log.wtf("test", "start Channels2Screen")
    val focusRequester = remember { FocusRequester() }
    val emptyFocusRequester = FocusRequester()

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
//    val uiState by viewModel.uiState.collectAsState()
//    val groupList by viewModel.groupList.collectAsState()
//    val channelList by viewModel.channelList.collectAsState()

//    val getGroupListFlow by viewModel.getGroupListFlow.collectAsState()
//    val getChannelListFlow by viewModel.getChannelListFlow.collectAsState()

//    var groupList by remember { mutableStateOf<List<Group>>(emptyList()) }
//    var channelList by remember { mutableStateOf<List<Channel>>(emptyList()) }
    var focusedGroupId by remember { mutableStateOf<String>(selectedGroupId) }
    val screenLabelText by viewModel.screenLabelText.collectAsState()

    LaunchedEffect(Unit) {
        Log.wtf("test", "Channels2Screen LaunchedEffect(Unit)")
        viewModel.getGroupList()
        viewModel.getChannelList()
    }

    LaunchedEffect(uiState) {
        Log.wtf("test", "Channels2Screen LaunchedEffect(uiState) uiState.groupList.count() = ${uiState.groupList.count()}, uiState.channelList.count() = ${uiState.channelList.count()}")
    }

    LaunchedEffect(focusedGroupId) {
        val focusedGroup = uiState.groupList.find { it.id == focusedGroupId }
//        val focusedGroup = groupList.find { it.id == focusedGroupId }
        Log.wtf("test", "Channels2Screen LaunchedEffect() focusedGroupId = ${focusedGroupId}")
        if (focusedGroup != null) {
            Log.wtf("test", "Channels2Screen LaunchedEffect() focusedGroup = ${focusedGroup.name}")
        }
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .onFocusChanged {
                Log.wtf("test", "Channels2Screen Box() onFocusChanged() isFocused = ${it.isFocused}, hasFocus = ${it.hasFocus}, isCaptured = ${it.isCaptured}")
                if (it.isFocused) {
                    focusRequester.requestFocus()
                }
            }
            .onFocusEvent {
                Log.wtf("test", "Channels2Screen Box() onFocusEvent() isFocused = ${it.isFocused}, hasFocus = ${it.hasFocus}, isCaptured = ${it.isCaptured}")
            }
    ) {
//        LaunchedEffect(Unit) {
//            if (groupList.isNotEmpty()) {
////                focusRequester.requestFocus()
//            }
//        }
        Column() {
            Text(
                text = screenLabelText,
                color = Color.White
            )

            Row {

                LazyColumn (
                    modifier = Modifier
                        .widthIn(max = 300.dp)
//                        .focusRequester(focusRequester)
                            .onFocusChanged {
                        Log.wtf("test", "Channels2Screen LazyColumn() onFocusChanged() isFocused = ${it.isFocused}, hasFocus = ${it.hasFocus}, isCaptured = ${it.isCaptured}")
                        if (it.isFocused) {
                            focusRequester.requestFocus()
                        }
                    }
                        .onFocusEvent {
                            Log.wtf("test", "Channels2Screen LazyColumn() onFocusEvent() isFocused = ${it.isFocused}, hasFocus = ${it.hasFocus}, isCaptured = ${it.isCaptured}")
                        }
                ) {
//                    itemsIndexed(groupList) { index, group ->
                    itemsIndexed(uiState.groupList) { index, group ->
//                        Log.wtf("test", "Channels2Screen itemsIndexed(): $index - ${group.name}")

                        ChannelGroupItemCard(
                            group = group,
                            modifier = Modifier
                                .focusRequester(if (index == 0) focusRequester else emptyFocusRequester),
//                                .focusRequester(focusRequester),
                            onFocus = {
//                                Log.wtf("test", "Channels2Screen ChannelGroupItemCard onFocus() ${group.name}")
//                                focusedGroup = group
                                focusedGroupId = group.id
                            },
                            onClick = {
                                Log.wtf("test", "Channels2Screen ChannelGroupItemCard onClick() ${group.name}")
                            }
                        )
                    }
                }

                LazyColumn(
                    modifier = Modifier
                        .onKeyEvent{
                            if(
                                it.type == KeyEventType.KeyDown &&
                                it.key == Key.DirectionRight
                            ) {
                                Log.wtf("test", "Channel1 click RIGHT")
                                navController.navigate(Screens.Main.TV.Programs.route)
                                true
                            } else {
                                false
                            }
                        }
                ) {
//                    itemsIndexed(channelList) { index, channel ->
                    itemsIndexed(uiState.channelList) { index, channel ->
                        ChannelCard(
                            channel = channel
                            )
                    }
                }
            }
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
    Channels2Screen(
        navController = rememberNavController(),
        selectedGroupId = ""
    )
}