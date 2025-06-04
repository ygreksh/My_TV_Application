package com.example.mytvapplication.domain.usecase

import com.example.mytvapplication.domain.model.LoginParams
import com.example.mytvapplication.domain.model.Movie
import com.example.mytvapplication.domain.repository.ApiRepository

class LoginUseCase(private val apiRepository: ApiRepository) {
    fun execute(): Boolean {
        val loginResult: Boolean =
            apiRepository.login(LoginParams(subscriptionId = "", password = ""))
        return loginResult
    }
}