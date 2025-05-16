package com.example.mytvapplication.ui.screens

sealed class Screens(val route: String) {
    data object Auth : Screens("auth") {
        data object SignUp : Screens("sign_up")
        data object SignIn : Screens("sign_in")
    }
    data object Main : Screens("main") {
        data object Home : Screens("home")
        data object TV : Screens("tv") {
            data object Channels : Screens("tv_channels")
            data object Programs : Screens("tv_programs")
        }
        data object Movies : Screens("movies")
        data object Search : Screens("search")
        data object Settings : Screens("settings")
    }
}