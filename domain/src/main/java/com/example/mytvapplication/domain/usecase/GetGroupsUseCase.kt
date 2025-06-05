package com.example.mytvapplication.domain.usecase

import com.example.mytvapplication.domain.model.Group
//import com.example.mytvapplication.domain.repository.ApiRepository
import com.example.mytvapplication.domain.repository.TVRepository

//class GetGroupsUseCase(private val apiRepository: ApiRepository) {
class GetGroupsUseCase(private val tvRepository: TVRepository) {
    fun execute() : List<Group> {
//        val result: List<Group> = apiRepository.getGroups()
        val result: List<Group> = tvRepository.getGroups()
        return result
    }
}