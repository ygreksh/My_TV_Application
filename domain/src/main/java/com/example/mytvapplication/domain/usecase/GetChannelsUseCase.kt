package com.example.mytvapplication.domain.usecase

import com.example.mytvapplication.domain.model.Channel
//import com.example.mytvapplication.domain.repository.ApiRepository
import com.example.mytvapplication.domain.repository.TVRepository

//class GetChannelsUseCase(private val apiRepository: ApiRepository) {
class GetChannelsUseCase(private val tvRepository: TVRepository) {
    fun execute() : List<Channel> {
//        val result: List<Channel> = apiRepository.getChannels()
        val result: List<Channel> = tvRepository.getChannels()
        return result
    }
}