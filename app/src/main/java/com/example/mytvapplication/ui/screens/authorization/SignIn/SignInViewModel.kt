package com.example.mytvapplication.ui.screens.authorization.SignIn

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytvapplication.domain.model.LoginParams
import com.example.mytvapplication.domain.repository.ApiResult
import com.example.mytvapplication.domain.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

data class SignInUiState(
    val isLoading: Boolean = false,
    val isLogged: Boolean = false,
)

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val appRepository: AppRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(SignInUiState())
    val uiState: StateFlow<SignInUiState> = _uiState.asStateFlow()

    private val _loginFlow = MutableStateFlow<ApiResult<Any>?>(null)
    val loginFlow: StateFlow<ApiResult<Any>?> = _loginFlow.asStateFlow()

    private val _userIsLoggedIn = MutableStateFlow<Boolean>(false)
    val userIsLoggedIn = _userIsLoggedIn

    fun login(params: LoginParams) {

        viewModelScope.launch {
            val result = appRepository.login(params)

//            when(result.collect()) {
//                is ApiResult.Success<Boolean> ->
//            }
            userIsLoggedIn.value = true
        }
    }
}