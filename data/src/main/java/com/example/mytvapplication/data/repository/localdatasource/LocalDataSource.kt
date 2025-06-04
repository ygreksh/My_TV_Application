package com.example.mytvapplication.data.repository.localdatasource

import com.example.mytvapplication.domain.model.Channel
import com.example.mytvapplication.domain.model.ChannelGroup
import com.example.mytvapplication.domain.model.LoginParams
import com.example.mytvapplication.domain.model.Movie
import com.example.mytvapplication.domain.repository.ApiRepository

class LocalDataSource : ApiRepository {
    override fun login(params: LoginParams): Boolean {
        TODO("Not yet implemented")
    }

    override fun getGroups(): List<ChannelGroup> {
        TODO("Not yet implemented")
    }

    override fun getChannels(): List<Channel> {
        TODO("Not yet implemented")
    }

    override fun getLastMovies(): List<Movie> {
        TODO("Not yet implemented")
    }
}