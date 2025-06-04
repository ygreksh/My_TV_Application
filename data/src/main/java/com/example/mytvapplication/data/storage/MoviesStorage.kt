package com.example.mytvapplication.data.storage

import com.example.mytvapplication.data.storage.model.Movie


interface MoviesStorage {
    fun getLastMovies(): List<Movie>
}