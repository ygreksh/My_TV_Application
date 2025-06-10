package com.example.mytvapplication.data.storage

import com.example.mytvapplication.domain.model.Channel
import com.example.mytvapplication.domain.model.Group
import com.example.mytvapplication.domain.model.Movie


interface LocalDataSource {
    fun getGroups() : List<Group>
    fun getChannels() : List<Channel>
    fun getLastMovies() : List<Movie>
}