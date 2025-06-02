package com.example.mytvapplication.domain.usecase

import com.example.mytvapplication.data.model.Channel
import com.example.mytvapplication.data.model.Movie
import com.example.mytvapplication.domain.repository.ApiRepository

class GetChannelsUseCase(private val apiRepository: ApiRepository) {
    fun execute(params: String) : List<Channel> {
//        return listOf(
//            Channel(id = "10", name = "Channel_1"),
//            Channel(id = "20", name = "Channel_2"),
//            Channel(id = "30", name = "Channel_3"),
//            Channel(id = "40", name = "Channel_4")
//        )
        val result: List<Channel> = apiRepository.getChannels()
        return result
    }
}