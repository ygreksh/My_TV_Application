package com.example.mytvapplication

sealed class Screens(val route: String) {
    data object Main : Screens("main") {
        data object Home : Screens("home")
        data object TV : Screens("tv")
        data object Movies : Screens("movies")
        data object Search : Screens("search")
        data object Settings : Screens("settings")
    }
}
