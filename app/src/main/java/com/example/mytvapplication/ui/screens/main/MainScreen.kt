package com.example.mytvapplication.ui.screens.main

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.mytvapplication.ui.screens.Screens
import com.example.mytvapplication.ui.navigation.mainNavGraph
import com.example.mytvapplication.ui.components.MyDrawer

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    rootNavController: NavHostController,
) {
    Log.wtf("test", "start MainScreen")
    val bottomBarNavController = rememberNavController()

    MyDrawer(
        modifier = modifier,
        rootNavController = rootNavController,
        bottomBarNavController = bottomBarNavController
    ) {
        NavHost(
            navController = bottomBarNavController,
            startDestination = Screens.Main.route,
        ) {
            mainNavGraph(
                rootNavController = rootNavController,
                navController = bottomBarNavController
            )
        }
    }
}

