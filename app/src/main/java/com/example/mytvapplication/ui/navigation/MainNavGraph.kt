package com.example.mytvapplication.ui.navigation

import android.util.Log
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.mytvapplication.ui.screens.main.movies.Movies2Screen
import com.example.mytvapplication.ui.screens.Screens
import com.example.mytvapplication.ui.screens.main.home.Home2Screen
import com.example.mytvapplication.ui.screens.main.search.Search2Screen
import com.example.mytvapplication.ui.screens.main.settings.Settings2Screen

fun NavGraphBuilder.mainNavGraph(
    rootNavController: NavHostController,
    navController: NavHostController
) {
    Log.wtf("test", "start NavGraphBuilder.mainNavGraph")
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