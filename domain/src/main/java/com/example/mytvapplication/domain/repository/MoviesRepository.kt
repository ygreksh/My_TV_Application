package com.example.mytvapplication.domain.repository

import com.example.mytvapplication.domain.model.Genre
import com.example.mytvapplication.domain.model.Movie

interface MoviesRepository {
    fun getGenres() : List<Genre>
    fun getLastMovies() : List<Movie>
    fun getBestMovies() : List<Movie>
    fun searchMovies() : List<Movie>
}