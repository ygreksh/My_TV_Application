package com.example.mytvapplication

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Monitor
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.tv.material3.ModalNavigationDrawer

@Composable
fun MyDrawer(
    modifier: Modifier = Modifier,
    rootNavController: NavHostController,
    bottomBarNavController: NavHostController,
) {
    ModalNavigationDrawer(
        modifier = modifier.background(Color.Black),
        drawerContent = {
            Log.wtf("test", "ModalNavigationDrawer drawerContent")
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                NavigationItem(it, Icons.Default.Home, "Home") {
                    Log.wtf("mainMenu", "onClick Home")
                    bottomBarNavController.navigate("home")
                }
                NavigationItem(it, Icons.Default.Movie, "Movies") {
                    Log.wtf("mainMenu", "onClick Movies")
                    bottomBarNavController.navigate("movies")
                }
                NavigationItem(it, Icons.Default.Monitor, "TV Shows") {
                    Log.wtf("mainMenu", "onClick TV Shows")
                    bottomBarNavController.navigate("tv")
                }
                NavigationItem(it, Icons.Default.Search, "Search") {
                    Log.wtf("mainMenu", "onClick Search")
                    bottomBarNavController.navigate("search")
                }
                NavigationItem(it, Icons.Default.Settings, "Settings") {
                    Log.wtf("mainMenu", "onClick Settings")
                    bottomBarNavController.navigate("settings")
                }
            }
        }
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