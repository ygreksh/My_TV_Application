package com.example.mytvapplication.domain.repository

import com.example.mytvapplication.domain.model.Channel
import com.example.mytvapplication.domain.model.Group
import com.example.mytvapplication.domain.model.Movie
import com.example.mytvapplication.domain.model.LoginParams

interface UserRepository {
    fun login(params: LoginParams) : Boolean
}