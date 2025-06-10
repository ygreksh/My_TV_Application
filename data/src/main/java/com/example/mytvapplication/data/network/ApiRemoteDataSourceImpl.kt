package com.example.mytvapplication.data.network

import com.example.mytvapplication.domain.model.Channel
import com.example.mytvapplication.domain.model.Group
import com.example.mytvapplication.domain.model.LoginParams
import com.example.mytvapplication.domain.model.Movie

class ApiRemoteDataSourceImpl : RemoteDataSource {
    override fun login(params: LoginParams): Boolean {
        return true
    }

    override fun getGroups(): List<Group> {
        return listOf(
            Group(id = "1", name = "RemoteGroup_1"),
            Group(id = "2", name = "RemoteGroup_2"),
            Group(id = "3", name = "RemoteGroup_3"),
            Group(id = "4", name = "RemoteGroup_4")
        )
    }

    override fun getChannels(): List<Channel> {
        return listOf(
            Channel(id = "1", name = "RemoteChannel_1", icon = ""),
            Channel(id = "2", name = "RemoteChannel_2", icon = ""),
            Channel(id = "3", name = "RemoteChannel_3", icon = ""),
            Channel(id = "4", name = "RemoteChannel_4", icon = "")
        )
    }

    override fun getLastMovies(): List<Movie> {
        return listOf(
            Movie(id = "101", name = "RemoteMovie_101", posterUri = "https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review/card.jpg", description = ""),
            Movie(id = "102", name = "RemoteMovie_102", posterUri = "https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review/card.jpg", description = ""),
            Movie(id = "103", name = "RemoteMovie_103", posterUri = "https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review/card.jpg", description = ""),
            Movie(id = "104", name = "RemoteMovie_104", posterUri = "https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review/card.jpg", description = ""),
            Movie(id = "105", name = "RemoteMovie_105", posterUri = "https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review/card.jpg", description = ""),
            Movie(id = "106", name = "RemoteMovie_106", posterUri = "https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review/card.jpg", description = ""),
            Movie(id = "107", name = "RemoteMovie_107", posterUri = "https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review/card.jpg", description = ""),
            Movie(id = "108", name = "RemoteMovie_108", posterUri = "https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review/card.jpg", description = "")
        )
    }
}