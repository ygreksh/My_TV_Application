package com.example.mytvapplication.domain.usecase

import com.example.mytvapplication.domain.model.Movie
import com.example.mytvapplication.domain.repository.AppRepository

class GetLastMoviesUseCase(private val appRepository: AppRepository) {
    fun execute() : List<Movie> {
        val result: List<Movie> = appRepository.getLastMovies()
        return result
    }
}