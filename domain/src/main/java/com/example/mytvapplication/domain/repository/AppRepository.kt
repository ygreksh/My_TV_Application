package com.example.mytvapplication.domain.repository

import com.example.mytvapplication.domain.model.Channel
import com.example.mytvapplication.domain.model.Group
import com.example.mytvapplication.domain.model.LoginParams
import com.example.mytvapplication.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface AppRepository {
//    fun login(params: LoginParams) : Boolean
    suspend fun login(params: LoginParams) : Flow<ApiResult<Boolean>>
    fun getGroups(): List<Group>
    fun getChannels(): List<Channel>
    fun getLastMovies(): List<Movie>
}