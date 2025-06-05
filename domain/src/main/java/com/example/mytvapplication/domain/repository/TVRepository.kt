package com.example.mytvapplication.domain.repository

import com.example.mytvapplication.domain.model.Channel
import com.example.mytvapplication.domain.model.Group

interface TVRepository {
    fun getGroups(): List<Group>
    fun getChannels(): List<Channel>
    fun getAllChannels(): List<Channel>
}