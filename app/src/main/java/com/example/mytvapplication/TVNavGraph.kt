package com.example.mytvapplication

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
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
            enterTransition = {
                slideInHorizontally (
                    initialOffsetX = { fullWidth -> -fullWidth },
                    animationSpec = tween(durationMillis = 500)
                )
            },
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { fullWidth -> -fullWidth },
                    animationSpec = tween(durationMillis = 500)
                )
            }
        ) {
            Channels2Screen(
                navController = navController
            )
        }

        composable(
            route = Screens.Main.TV.Programs.route,
            enterTransition = {
                slideInHorizontally (
                    initialOffsetX = { fullWidth -> fullWidth },
                    animationSpec = tween(durationMillis = 500)
                )
            },
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { fullWidth -> fullWidth },
                    animationSpec = tween(durationMillis = 500)
                )
            }
        ) {
            Programs2Screen(
                rootNavController = rootNavController,
                navController = navController
            )
        }
    }
}