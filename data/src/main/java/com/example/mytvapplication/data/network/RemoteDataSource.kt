package com.example.mytvapplication.data.network

import com.example.mytvapplication.domain.model.Channel
import com.example.mytvapplication.domain.model.Group
import com.example.mytvapplication.domain.model.Movie
import com.example.mytvapplication.domain.model.LoginParams

interface RemoteDataSource {
    fun login(params: LoginParams) : Boolean
    fun getGroups() : List<Group>
    fun getChannels() : List<Channel>
    fun getLastMovies() : List<Movie>
}