package com.example.mytvapplication.domain.usecase

import com.example.mytvapplication.domain.model.Group
import com.example.mytvapplication.domain.repository.AppRepository
//import com.example.mytvapplication.domain.repository.ApiRepository
import com.example.mytvapplication.domain.repository.TVRepository

class GetGroupsUseCase(private val appRepository: AppRepository) {
    fun execute() : List<Group> {
        val result: List<Group> = appRepository.getGroups()
        return result
    }
}