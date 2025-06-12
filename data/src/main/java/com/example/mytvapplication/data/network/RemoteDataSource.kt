package com.example.mytvapplication.data.network

import com.example.mytvapplication.domain.model.Channel
import com.example.mytvapplication.domain.model.Group
import com.example.mytvapplication.domain.model.Movie
import com.example.mytvapplication.domain.model.LoginParams
import com.example.mytvapplication.domain.repository.ApiResult
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    fun login(params: LoginParams) : Flow<ApiResult<Boolean>>
    fun getGroups() : List<Group>
    fun getChannels() : List<Channel>
    fun getLastMovies() : List<Movie>
}