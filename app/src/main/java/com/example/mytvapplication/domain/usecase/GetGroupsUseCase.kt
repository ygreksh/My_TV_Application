package com.example.mytvapplication.domain.usecase

import com.example.mytvapplication.data.model.Channel
import com.example.mytvapplication.data.model.ChannelGroup
import com.example.mytvapplication.data.model.Movie
import com.example.mytvapplication.domain.repository.ApiRepository

class GetGroupsUseCase(private val apiRepository: ApiRepository) {
    fun execute() : List<ChannelGroup> {
        val result: List<ChannelGroup> = apiRepository.getGroups()
        return result
    }
}