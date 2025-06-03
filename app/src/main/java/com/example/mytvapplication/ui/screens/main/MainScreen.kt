package com.example.mytvapplication.ui.screens.main

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
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
    val bottomBarNavController = rememberNavController()
    var currentselectedId by remember { mutableStateOf("home") }
    Log.wtf("test", "start MainScreen, currentselectedId = $currentselectedId")
    val focusRequester = remember { FocusRequester() }

    MyDrawer(
        modifier = modifier,
        rootNavController = rootNavController,
        bottomBarNavController = bottomBarNavController,
//        selectedId = "home",
        selectedId = currentselectedId,
        focusRequester = focusRequester,
        onSelectItem = { menuItem ->
            currentselectedId = menuItem
            Log.wtf("test", "MainScreen onSelectItem(): currentselectedId = $currentselectedId")
        }
    ) {
//        Log.wtf("test", "MainScreen onSelectItem(): currentselectedId = $currentselectedId")
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

