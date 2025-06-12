package com.example.mytvapplication.domain.usecase

import com.example.mytvapplication.domain.model.LoginParams
import com.example.mytvapplication.domain.repository.ApiResult
import com.example.mytvapplication.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow

class LoginUseCase(private val appRepository: AppRepository) {
//    suspend fun execute(): Boolean {
//        val loginResult =
//            appRepository.login(LoginParams(subscriptionId = "", password = ""))
//        if (loginResult is ApiResult.Success<*>) {
//            return true
//        }
//
////        when (loginResult) {
////            is ApiResult.Error -> return false
////            is ApiResult.Loading -> return false
////            is ApiResult.Success -> return true
////        }
//
//        return false
//    }

    suspend fun execute(): Flow<ApiResult<Boolean>> {
        val loginResult =
            appRepository.login(LoginParams(subscriptionId = "", password = ""))
        return loginResult
    }
}