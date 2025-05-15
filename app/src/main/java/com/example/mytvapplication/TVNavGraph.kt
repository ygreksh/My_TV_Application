package com.example.mytvapplication

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.tvNavGraph(
    rootNavController: NavHostController,
    navController: NavHostController
) {
    navigation(
        route = Screens.Main.TV.route,
        startDestination = Screens.Main.TV.Channels.route,
    ) {
        composable(
            route = Screens.Main.TV.Channels.route,
        ) {
            Channels2Screen(
                navController = navController
            )
        }

        composable(
            route = Screens.Main.TV.Programs.route,
        ) {
            Programs2Screen(
                navController = navController
            )
        }
    }
}