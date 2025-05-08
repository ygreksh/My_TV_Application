package com.example.mytvapplication

import android.util.Log
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun RootNavGraph() {
    val rootNavController = rememberNavController()

    NavHost(
        navController = rootNavController,
        startDestination = Screens.Main.route,
    ) {
        composable(
            route = Screens.Main.route,
        ) {
            MainScreen(rootNavController = rootNavController)
        }

        composable(
            route = Screens.Account.route,
        ) {
//            AccountScreen(rootNavController = rootNavController)
        }

        composable(
            route = Screens.Search.route,
        ) {
            Log.wtf("test", "RootNavGraph: try start SearchScreen")
            Search2Screen(rootNavController = rootNavController)
        }
    }
}