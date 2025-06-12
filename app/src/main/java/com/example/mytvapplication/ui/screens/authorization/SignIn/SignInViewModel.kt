package com.example.mytvapplication.ui.screens.authorization.SignIn

import androidx.lifecycle.ViewModel
import com.example.mytvapplication.domain.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val appRepository: AppRepository
) : ViewModel() {

}