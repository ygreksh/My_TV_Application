package com.example.mytvapplication.data.repository

import com.example.mytvapplication.data.model.Channel
import com.example.mytvapplication.data.model.Movie
import com.example.mytvapplication.domain.model.LoginParams
import com.example.mytvapplication.domain.repository.ApiRepository

class ApiRepositoryImpl : ApiRepository{
    override fun login(params: LoginParams) {
        TODO("Not yet implemented")
    }

    override fun getChannels() : List<Channel> {
        return listOf(
            Channel(id = "10", name = "Channel_1"),
            Channel(id = "20", name = "Channel_2"),
            Channel(id = "30", name = "Channel_3"),
            Channel(id = "40", name = "Channel_4")
        )
    }

    override fun getLastMovies() : List<Movie> {
        return listOf(
            Movie(id = "101", name = "Movie_101", posterUri = "", description = ""),
            Movie(id = "102", name = "Movie_102", posterUri = "", description = ""),
            Movie(id = "103", name = "Movie_103", posterUri = "", description = ""),
            Movie(id = "104", name = "Movie_104", posterUri = "", description = ""),
            Movie(id = "105", name = "Movie_105", posterUri = "", description = ""),
            Movie(id = "106", name = "Movie_106", posterUri = "", description = ""),
            Movie(id = "107", name = "Movie_107", posterUri = "", description = ""),
            Movie(id = "108", name = "Movie_108", posterUri = "", description = "")
        )
    }
}