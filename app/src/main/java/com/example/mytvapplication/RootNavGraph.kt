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
fun RootNavGraph(

) {
    val rootNavController = rememberNavController()
    val bottomBarNavController = rememberNavController()

    NavHost(
        navController = rootNavController,
        startDestination = Screens.Main.route,
    ) {
        composable(
            route = Screens.Main.route,
//            enterTransition = {
//                fadeIn(animationSpec = tween(durationMillis = 100))
//            },
//            exitTransition = {
//                fadeOut(animationSpec = tween(durationMillis = 100))
//            }
        ) {
            MainScreen(rootNavController = rootNavController)
        }

//        mainNavGraph(
//            rootNavController = rootNavController,
//            navController = bottomBarNavController
//        )

//        composable(
//            route = Screens.Main.route,
//        ) {
//            MainScreen(rootNavController = rootNavController)
//        }
//
//        composable(
//            route = Screens.Main.Home.route,
//        ) {
//            Log.wtf("test", "RootNavGraph: try start HomeScreen")
//            Home2Screen(rootNavController = rootNavController)
//        }
//
//        composable(
//            route = Screens.Main.Search.route,
//        ) {
//            Log.wtf("test", "RootNavGraph: try start SearchScreen")
//            Search2Screen(rootNavController = rootNavController)
//        }
//
//        composable(
//            route = Screens.Main.TV.route,
//        ) {
//            Log.wtf("test", "RootNavGraph: try start TVScreen")
//            TV2Screen(rootNavController = rootNavController)
//        }
//
//        composable(
//            route = Screens.Main.Movies.route,
//        ) {
//            Log.wtf("test", "RootNavGraph: try start MoviesScreen")
//            Movies2Screen(rootNavController = rootNavController)
//        }
//
//
//        composable(
//            route = Screens.Main.Settings.route,
//        ) {
//            Log.wtf("test", "RootNavGraph: try start SettingsScreen")
//            Settings2Screen(rootNavController = rootNavController)
//        }
    }
}