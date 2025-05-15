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

fun NavGraphBuilder.authNavGraph(
    rootNavController: NavHostController,
    navController: NavHostController
) {
    navigation(
        route = Screens.Auth.route,
        startDestination = Screens.Auth.SignIn.route,
    ) {
        composable(
            route = Screens.Auth.SignIn.route,
        ) {
            SignIn2Screen(
                rootNavController = rootNavController,
                navController = navController
            )
        }
    }
}