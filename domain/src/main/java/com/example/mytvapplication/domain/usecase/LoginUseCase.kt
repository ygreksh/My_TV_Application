package com.example.mytvapplication.domain.usecase

import com.example.mytvapplication.domain.model.LoginParams
import com.example.mytvapplication.domain.repository.AppRepository

class LoginUseCase(private val appRepository: AppRepository) {
    fun execute(): Boolean {
        val loginResult: Boolean =
            appRepository.login(LoginParams(subscriptionId = "", password = ""))
        return loginResult
    }
}