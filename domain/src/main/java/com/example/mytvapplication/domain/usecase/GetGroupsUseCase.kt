package com.example.mytvapplication.domain.usecase

import com.example.mytvapplication.domain.model.Group
import com.example.mytvapplication.domain.repository.ApiResult
import com.example.mytvapplication.domain.repository.AppRepository
//import com.example.mytvapplication.domain.repository.ApiRepository
import com.example.mytvapplication.domain.repository.TVRepository
import kotlinx.coroutines.flow.Flow

class GetGroupsUseCase(private val appRepository: AppRepository) {
    fun execute() : Flow<ApiResult<List<Group>>> {
        val result = appRepository.getGroups()
        return result
    }
}