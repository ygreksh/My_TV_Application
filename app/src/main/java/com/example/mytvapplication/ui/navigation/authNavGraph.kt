package com.example.mytvapplication.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.mytvapplication.ui.screens.Screens
import com.example.mytvapplication.ui.screens.authorization.SignIn2Screen

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
//                navController = navController
            )
        }
    }
}