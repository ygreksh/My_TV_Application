package com.example.mytvapplication.domain.usecase

class LoginUseCase(val subscriptionId: String) {
    fun execute(subscriptionId: String) : Boolean {
        if (subscriptionId == "123456") {

            return true
        } else {

            return false
        }
    }
}