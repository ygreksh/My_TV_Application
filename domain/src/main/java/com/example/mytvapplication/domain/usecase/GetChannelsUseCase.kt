package com.example.mytvapplication.domain.usecase

import com.example.mytvapplication.domain.model.Channel
import com.example.mytvapplication.domain.repository.ApiResult
import com.example.mytvapplication.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow

class GetChannelsUseCase(private val appRepository: AppRepository) {
    fun execute() : Flow<ApiResult<List<Channel>>> {
        val result = appRepository.getChannels()
        return result
    }
}