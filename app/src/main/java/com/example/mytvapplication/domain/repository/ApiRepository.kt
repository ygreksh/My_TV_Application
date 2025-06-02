package com.example.mytvapplication.domain.repository

import com.example.mytvapplication.domain.model.LoginParams

interface ApiRepository {
    fun login(params: LoginParams)
    fun getChannels()
}