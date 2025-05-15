package com.example.mytvapplication

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.mainNavGraph(
    rootNavController: NavHostController,
    navController: NavHostController
) {
    navigation(
        route = Screens.Main.route,
        startDestination = Screens.Main.Home.route,
    ) {
        composable(
            route = Screens.Main.Home.route,
        ) {
            Home2Screen(
                navController = navController
            )
        }

        composable(
            route = Screens.Main.Movies.route,
        ) {
            Movies2Screen(
                navController = navController
            )
        }

//        composable(
//            route = Screens.Main.TV.route,
//        ) {
//            TV2Screen(
//                navController = navController
//            )
//        }
        tvNavGraph(
            rootNavController = rootNavController,
            navController = navController
        )

        composable(
            route = Screens.Main.Search.route,
        ) {
            Search2Screen(
                navController = navController
            )
        }

        composable(
            route = Screens.Main.Settings.route,
        ) {
            Settings2Screen(
                navController = navController
            )
        }

    }
}