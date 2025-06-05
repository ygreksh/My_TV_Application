package com.example.mytvapplication.domain.usecase

import com.example.mytvapplication.domain.model.Movie
import com.example.mytvapplication.domain.repository.MoviesRepository

//class GetLastMoviesUseCase(private val movie: ApiRepository) {
class GetLastMoviesUseCase(private val moviesRepository: MoviesRepository) {
    fun execute() : List<Movie> {
//        val result: List<Movie> = apiRepository.getLastMovies()
        val result: List<Movie> = moviesRepository.getLastMovies()
        return result
    }
}