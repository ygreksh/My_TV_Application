package com.example.mytvapplication.ui.screens.main.tv.Channels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytvapplication.domain.model.Channel
import com.example.mytvapplication.domain.model.Group
import com.example.mytvapplication.domain.model.LoginParams
import com.example.mytvapplication.domain.repository.ApiResult
import com.example.mytvapplication.domain.repository.AppRepository
import com.example.mytvapplication.domain.usecase.GetChannelsUseCase
import com.example.mytvapplication.domain.usecase.GetGroupsUseCase
import com.example.mytvapplication.ui.screens.authorization.SignIn.SignInUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
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

    val getGroupsUseCase =
        GetGroupsUseCase(appRepository = appRepository)
    val getChannelsUseCase =
        GetChannelsUseCase(appRepository = appRepository)

    private val _uiState = MutableStateFlow(ChannelsScreenUiState())
    val uiState: StateFlow<ChannelsScreenUiState> = _uiState.asStateFlow()

    private val _getGroupListFlow = MutableStateFlow<ApiResult<Any>?>(null)
    val getGroupListFlow: StateFlow<ApiResult<Any>?> = _getGroupListFlow.asStateFlow()

    private val _getChannelListFlow = MutableStateFlow<ApiResult<Any>?>(null)
    val getChannelListFlow: StateFlow<ApiResult<Any>?> = _getChannelListFlow.asStateFlow()

    val defaultScreenLabelText = "Channels2Screen"
    private val _screenLabelText = MutableStateFlow<String>(defaultScreenLabelText)
    val screenLabelText: StateFlow<String> = _screenLabelText.asStateFlow()

//    private val _groupList = MutableStateFlow<List<Group>>(emptyList<Group>())
//    val groupList: StateFlow<List<Group>> = _groupList.asStateFlow()

//    private val _channelList = MutableStateFlow<List<Channel>>(emptyList<Channel>())
//    val channelList: StateFlow<List<Channel>> = _channelList.asStateFlow()

    fun getGroupList() {
        Log.wtf("test", "ChannelsViewModel getGroupList() start")

        viewModelScope.launch {
//            appRepository.getGroups()
            getGroupsUseCase.execute()
                .collect { result ->
                    when (result) {
                        is ApiResult.Loading -> {
                            Log.wtf("test", "ChannelsViewModel getGroupList() Loading")
//                            _uiState.value.isLoading = true
                            _uiState.update{ it.copy(isLoading = true)}
                            _screenLabelText.value = "Loading groups"
                        }
                        is ApiResult.Success -> {
                            _uiState.update{ it.copy(isLoading = false)}
//                            _uiState.value.isLoading = false
                            _screenLabelText.value = defaultScreenLabelText
                            Log.wtf("test", "ChannelsViewModel getGroupList() Success: groupList.count() = ${result.result.count()}")
//                            _uiState.value.groupList = result.result
                            _uiState.update{ it.copy(groupList = result.result)}
                        }
                        is ApiResult.Error -> {
//                            _uiState.value.isLoading = false
                            _uiState.update{ it.copy(isLoading = false)}
                            _screenLabelText.value = defaultScreenLabelText
                        }
                    }

                }
        }
    }

    fun getChannelList() {
        Log.wtf("test", "ChannelsViewModel getChannelList() start")

        viewModelScope.launch {
//            appRepository.getChannels()
            getChannelsUseCase.execute()
                .collect { result ->
                    when (result) {
                        is ApiResult.Loading -> {
                            Log.wtf("test", "ChannelsViewModel getChannelList() Loading")
                            _uiState.value.isLoading = true
                            _screenLabelText.value = "Loading channels"
                        }
                        is ApiResult.Success -> {
                            _uiState.value.isLoading = false
                            _screenLabelText.value = defaultScreenLabelText
                            Log.wtf("test", "ChannelsViewModel getChannelList() Success: channelList.count() = ${result.result.count()}")
//                            _uiState.value.channelList = result.result
                            _uiState.update{ it.copy(channelList = result.result)}
                        }
                        is ApiResult.Error -> {
                            _uiState.value.isLoading = false
                            _screenLabelText.value = defaultScreenLabelText
                        }
                    }

                }
        }
    }
}