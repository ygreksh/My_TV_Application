package com.example.mytvapplication

sealed class Screens(val route: String) {
    data object Main : Screens("main")
    data object Home : Screens("home")
    data object Account : Screens("account")
    data object Search : Screens("search")
}
