package com.example.mytvapplication.data.repository

import com.example.mytvapplication.domain.model.Channel
import com.example.mytvapplication.domain.model.Group
import com.example.mytvapplication.domain.model.Movie
import com.example.mytvapplication.domain.model.LoginParams
import com.example.mytvapplication.domain.repository.UserRepository

class UserRepositoryImpl : UserRepository {
    override fun login(params: LoginParams) : Boolean {
        return true
    }
}