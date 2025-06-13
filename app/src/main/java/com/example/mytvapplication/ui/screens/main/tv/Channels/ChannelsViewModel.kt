package com.example.mytvapplication.ui.screens.main.tv.Channels

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

    fun getGroupList() {

        viewModelScope.launch {
            appRepository.getGroups()
                .collect { result ->
                    when (result) {
                        is ApiResult.Loading -> uiState.value.isLoading = true
                        is ApiResult.Success -> uiState.value.groupList = result.result
                        is ApiResult.Error -> uiState.value.isLoading = true
                    }

                }
        }
    }

    fun getChannelList() {

        viewModelScope.launch {
            appRepository.getChannels()
                .collect { result ->
                    when (result) {
                        is ApiResult.Loading -> uiState.value.isLoading = true
                        is ApiResult.Success -> uiState.value.channelList = result.result
                        is ApiResult.Error -> uiState.value.isLoading = true
                    }

                }
        }
    }
}