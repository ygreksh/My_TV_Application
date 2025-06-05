package com.example.mytvapplication.domain.usecase

import com.example.mytvapplication.domain.model.LoginParams
import com.example.mytvapplication.domain.repository.UserRepository

//class LoginUseCase(private val apiRepository: ApiRepository) {
class LoginUseCase(private val userRepository: UserRepository) {
    fun execute(): Boolean {
        val loginResult: Boolean =
//            apiRepository.login(LoginParams(subscriptionId = "", password = ""))
            userRepository.login(LoginParams(subscriptionId = "", password = ""))
        return loginResult
    }
}