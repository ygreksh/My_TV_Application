package com.example.mytvapplication.domain.repository

import com.example.mytvapplication.data.model.Channel
import com.example.mytvapplication.data.model.ChannelGroup
import com.example.mytvapplication.data.model.Movie
import com.example.mytvapplication.domain.model.LoginParams

interface ApiRepository {
    fun login(params: LoginParams)
    fun getGroups() : List<ChannelGroup>
    fun getChannels() : List<Channel>
    fun getLastMovies() : List<Movie>
}