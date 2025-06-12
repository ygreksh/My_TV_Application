package com.example.mytvapplication.ui.screens.main.settings

import androidx.lifecycle.ViewModel
import com.example.mytvapplication.domain.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val appRepository: AppRepository
) : ViewModel() {
}