package com.example.mytvapplication

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Monitor
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.tv.material3.DrawerValue
import androidx.tv.material3.Icon
import androidx.tv.material3.ModalNavigationDrawer
import androidx.tv.material3.OutlinedButton
import androidx.tv.material3.Text

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

