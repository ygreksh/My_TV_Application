package com.example.mytvapplication.data.repository

import com.example.mytvapplication.domain.model.Genre
import com.example.mytvapplication.domain.model.Movie
import com.example.mytvapplication.domain.repository.MoviesRepository

class MoviesRepositoryImpl : MoviesRepository {
    override fun getGenres(): List<Genre> {
        return listOf(
            Genre(id = "331", name = "Genre_101"),
            Genre(id = "332", name = "Genre_102"),
            Genre(id = "333", name = "Genre_103"),
            Genre(id = "334", name = "Genre_104"),
            Genre(id = "335", name = "Genre_105"),
            Genre(id = "336", name = "Genre_106"),
        )
    }

    override fun getLastMovies(): List<Movie> {
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

    override fun getBestMovies(): List<Movie> {
        return listOf(
            Movie(id = "901", name = "Movie_901", posterUri = "https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review/card.jpg", description = ""),
            Movie(id = "902", name = "Movie_902", posterUri = "https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review/card.jpg", description = ""),
            Movie(id = "903", name = "Movie_903", posterUri = "https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review/card.jpg", description = ""),
            Movie(id = "904", name = "Movie_904", posterUri = "https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review/card.jpg", description = ""),
            Movie(id = "905", name = "Movie_905", posterUri = "https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review/card.jpg", description = ""),
            Movie(id = "906", name = "Movie_906", posterUri = "https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review/card.jpg", description = ""),
            Movie(id = "907", name = "Movie_907", posterUri = "https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review/card.jpg", description = ""),
            Movie(id = "908", name = "Movie_908", posterUri = "https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review/card.jpg", description = "")
        )
    }

    override fun searchMovies(): List<Movie> {
        return listOf(
            Movie(id = "701", name = "Movie_701", posterUri = "https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review/card.jpg", description = ""),
            Movie(id = "702", name = "Movie_702", posterUri = "https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review/card.jpg", description = ""),
            Movie(id = "703", name = "Movie_703", posterUri = "https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review/card.jpg", description = ""),
        )
    }
}