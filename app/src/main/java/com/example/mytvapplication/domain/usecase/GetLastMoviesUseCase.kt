package com.example.mytvapplication.domain.usecase

import com.example.mytvapplication.data.model.Channel
import com.example.mytvapplication.data.model.Movie
import com.example.mytvapplication.domain.repository.ApiRepository

class GetLastMoviesUseCase(private val apiRepository: ApiRepository) {
    fun execute() : List<Movie> {
//        return listOf(
//            Movie(id = "101", name = "Movie_101", posterUri = "", description = ""),
//            Movie(id = "102", name = "Movie_102", posterUri = "", description = ""),
//            Movie(id = "103", name = "Movie_103", posterUri = "", description = ""),
//            Movie(id = "104", name = "Movie_104", posterUri = "", description = ""),
//            Movie(id = "105", name = "Movie_105", posterUri = "", description = ""),
//            Movie(id = "106", name = "Movie_106", posterUri = "", description = ""),
//            Movie(id = "107", name = "Movie_107", posterUri = "", description = ""),
//            Movie(id = "108", name = "Movie_108", posterUri = "", description = "")
//        )
        val result: List<Movie> = apiRepository.getLastMovies()
        return result
    }
}