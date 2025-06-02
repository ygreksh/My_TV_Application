package com.example.mytvapplication.domain.repository

import com.example.mytvapplication.data.model.Channel
import com.example.mytvapplication.data.model.Movie
import com.example.mytvapplication.domain.model.LoginParams

interface ApiRepository {
    fun login(params: LoginParams)
    fun getChannels() : List<Channel>
    fun getLastMovies() : List<Movie>
}