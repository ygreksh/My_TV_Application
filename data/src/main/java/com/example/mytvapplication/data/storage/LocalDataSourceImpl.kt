package com.example.mytvapplication.data.storage

import com.example.mytvapplication.domain.model.Channel
import com.example.mytvapplication.domain.model.Group
import com.example.mytvapplication.domain.model.Movie

class LocalDataSourceImpl : LocalDataSource {
    override fun getGroups(): List<Group> {
        return listOf(
            Group(id = "1", name = "LocalGroup_1"),
            Group(id = "2", name = "LocalGroup_2"),
            Group(id = "3", name = "LocalGroup_3"),
            Group(id = "4", name = "LocalGroup_4")
        )
    }

    override fun getChannels(): List<Channel> {
        return listOf(
            Channel(id = "1", name = "LocalChannel_1", icon = ""),
            Channel(id = "2", name = "LocalChannel_2", icon = ""),
            Channel(id = "3", name = "LocalChannel_3", icon = ""),
            Channel(id = "4", name = "LocalChannel_4", icon = "")
        )
    }

    override fun getLastMovies(): List<Movie> {
        return listOf(
            Movie(id = "101", name = "LocalMovie_101", posterUri = "https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review/card.jpg", description = ""),
            Movie(id = "102", name = "LocalMovie_102", posterUri = "https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review/card.jpg", description = ""),
            Movie(id = "103", name = "LocalMovie_103", posterUri = "https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review/card.jpg", description = ""),
            Movie(id = "104", name = "LocalMovie_104", posterUri = "https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review/card.jpg", description = ""),
            Movie(id = "105", name = "LocalMovie_105", posterUri = "https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review/card.jpg", description = ""),
            Movie(id = "106", name = "LocalMovie_106", posterUri = "https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review/card.jpg", description = ""),
            Movie(id = "107", name = "LocalMovie_107", posterUri = "https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review/card.jpg", description = ""),
            Movie(id = "108", name = "LocalMovie_108", posterUri = "https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review/card.jpg", description = "")
        )
    }
}