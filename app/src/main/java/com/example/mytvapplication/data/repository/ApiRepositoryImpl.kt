package com.example.mytvapplication.data.repository

import com.example.mytvapplication.data.model.Channel
import com.example.mytvapplication.data.model.ChannelGroup
import com.example.mytvapplication.data.model.Movie
import com.example.mytvapplication.domain.model.LoginParams
import com.example.mytvapplication.domain.repository.ApiRepository

class ApiRepositoryImpl : ApiRepository{
    override fun login(params: LoginParams) {
        TODO("Not yet implemented")
    }

    override fun getChannels() : List<Channel> {
        return listOf(
            Channel(id = "10", name = "Channel_1", icon = ""),
            Channel(id = "20", name = "Channel_2", icon = ""),
            Channel(id = "30", name = "Channel_3", icon = ""),
            Channel(id = "40", name = "Channel_4", icon = "")
        )
    }

    override fun getGroups() : List<ChannelGroup> {
        return listOf(
            ChannelGroup(id = "21", name = "Group_1"),
            ChannelGroup(id = "22", name = "Group_2"),
            ChannelGroup(id = "23", name = "Group_3"),
            ChannelGroup(id = "24", name = "Group_4"),
            ChannelGroup(id = "25", name = "Group_5"),
        )
    }

    override fun getLastMovies() : List<Movie> {
        return listOf(
            Movie(id = "101", name = "Movie_101", posterUri = "https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review/card.jpg", description = ""),
            Movie(id = "102", name = "Movie_102", posterUri = "https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review/card.jpg", description = ""),
            Movie(id = "103", name = "Movie_103", posterUri = "https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review/card.jpg", description = ""),
            Movie(id = "104", name = "Movie_104", posterUri = "https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review/card.jpg", description = ""),
            Movie(id = "105", name = "Movie_105", posterUri = "https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review/card.jpg", description = ""),
            Movie(id = "106", name = "Movie_106", posterUri = "https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review/card.jpg", description = ""),
            Movie(id = "107", name = "Movie_107", posterUri = "https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review/card.jpg", description = ""),
            Movie(id = "108", name = "Movie_108", posterUri = "https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review/card.jpg", description = "")
        )
    }
}