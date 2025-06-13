package com.example.mytvapplication.ui.screens.main.tv.Channels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytvapplication.domain.model.Channel
import com.example.mytvapplication.domain.model.Group
import com.example.mytvapplication.domain.model.LoginParams
import com.example.mytvapplication.domain.repository.ApiResult
import com.example.mytvapplication.domain.repository.AppRepository
import com.example.mytvapplication.ui.screens.authorization.SignIn.SignInUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ChannelsScreenUiState(
    var isLoading: Boolean = false,
    var groupList: List<Group> = emptyList(),
    var channelList: List<Channel> = emptyList(),
)

@HiltViewModel
class ChannelsViewModel @Inject constructor(
    private val appRepository: AppRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(ChannelsScreenUiState())
    val uiState: StateFlow<ChannelsScreenUiState> = _uiState.asStateFlow()

    private val _getGroupListFlow = MutableStateFlow<ApiResult<Any>?>(null)
    val getGroupListFlow: StateFlow<ApiResult<Any>?> = _getGroupListFlow.asStateFlow()

    private val _getChannelListFlow = MutableStateFlow<ApiResult<Any>?>(null)
    val getChannelListFlow: StateFlow<ApiResult<Any>?> = _getChannelListFlow.asStateFlow()

    private val _groupList = MutableStateFlow<List<Group>>(emptyList<Group>())
    val groupList: StateFlow<List<Group>> = _groupList.asStateFlow()

    private val _channelList = MutableStateFlow<List<Channel>>(emptyList<Channel>())
    val channelList: StateFlow<List<Channel>> = _channelList.asStateFlow()

    fun getGroupList() {
        Log.wtf("test", "ChannelsViewModel getGroupList() start")

        viewModelScope.launch {
            appRepository.getGroups()
                .collect { result ->
                    when (result) {
                        is ApiResult.Loading -> {
                            Log.wtf("test", "ChannelsViewModel getGroupList() Loading")
                            _uiState.value.isLoading = true
                        }
                        is ApiResult.Success -> {
                            _uiState.value.isLoading = false
                            Log.wtf("test", "ChannelsViewModel getGroupList() Success: groupList.count() = ${result.result.count()}")
                            _uiState.value.groupList = result.result
                        }
                        is ApiResult.Error -> _uiState.value.isLoading = false
                    }

                }
        }
    }

    fun getChannelList() {
        Log.wtf("test", "ChannelsViewModel getChannelList() start")

        viewModelScope.launch {
            appRepository.getChannels()
                .collect { result ->
                    when (result) {
                        is ApiResult.Loading -> {
                            Log.wtf("test", "ChannelsViewModel getChannelList() Loading")
                            _uiState.value.isLoading = true
                        }
                        is ApiResult.Success -> {
                            _uiState.value.isLoading = false
                            Log.wtf("test", "ChannelsViewModel getChannelList() Success: channelList.count() = ${result.result.count()}")
                            _uiState.value.channelList = result.result
                        }
                        is ApiResult.Error -> _uiState.value.isLoading = false
                    }

                }
        }
    }
}