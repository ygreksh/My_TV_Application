package com.example.mytvapplication.data.repository

import com.example.mytvapplication.data.storage.ChannelsStorage
import com.example.mytvapplication.data.storage.GroupsStorage
import com.example.mytvapplication.domain.model.Channel
import com.example.mytvapplication.domain.model.Group
import com.example.mytvapplication.domain.repository.TVRepository

class TVRepositoryImpl(
    val channelsStorage: ChannelsStorage,
    val groupStorage: GroupsStorage,
) : TVRepository {
    override fun getGroups(): List<Group> {
        return listOf(
            Group(id = "1", name = "Group_1"),
            Group(id = "2", name = "Group_2"),
            Group(id = "3", name = "Group_3"),
            Group(id = "4", name = "Group_4")
        )

//        val localResult = localDataSource.getGroups()
//        if (localResult.isNotEmpty()) {
//            return localResult
//        }
//        else {
//            val remoteResult = remoteDataSource.getGroups()
//            return remoteResult
//        }
    }

    override fun getChannels(): List<Channel> {
        return listOf(
            Channel(id = "1", name = "Channel_1", icon = ""),
            Channel(id = "2", name = "Channel_2", icon = ""),
            Channel(id = "3", name = "Channel_3", icon = ""),
            Channel(id = "4", name = "Channel_4", icon = "")
        )
    }

    override fun getAllChannels(): List<Channel> {
        return listOf(
            Channel(id = "1", name = "Channel_1", icon = ""),
            Channel(id = "2", name = "Channel_2", icon = ""),
            Channel(id = "3", name = "Channel_3", icon = ""),
            Channel(id = "4", name = "Channel_4", icon = ""),
            Channel(id = "11", name = "Channel_11", icon = ""),
            Channel(id = "12", name = "Channel_12", icon = ""),
            Channel(id = "13", name = "Channel_13", icon = ""),
            Channel(id = "14", name = "Channel_14", icon = ""),
        )
    }
}