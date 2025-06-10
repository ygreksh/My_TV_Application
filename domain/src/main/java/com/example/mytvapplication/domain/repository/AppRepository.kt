package com.example.mytvapplication.domain.repository

import com.example.mytvapplication.domain.model.Channel
import com.example.mytvapplication.domain.model.Group
import com.example.mytvapplication.domain.model.LoginParams
import com.example.mytvapplication.domain.model.Movie

interface AppRepository {
    fun login(params: LoginParams) : Boolean
    fun getGroups(): List<Group>
    fun getChannels(): List<Channel>
    fun getLastMovies(): List<Movie>
}