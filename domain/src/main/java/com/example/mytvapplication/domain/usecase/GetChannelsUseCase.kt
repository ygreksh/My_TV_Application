package com.example.mytvapplication.domain.usecase

import com.example.mytvapplication.domain.model.Channel
import com.example.mytvapplication.domain.repository.AppRepository

class GetChannelsUseCase(private val appRepository: AppRepository) {
    fun execute() : List<Channel> {
        val result: List<Channel> = appRepository.getChannels()
        return result
    }
}