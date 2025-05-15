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
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Monitor
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.tv.material3.DrawerValue
import androidx.tv.material3.Icon
import androidx.tv.material3.ModalNavigationDrawer
import androidx.tv.material3.OutlinedButton
import androidx.tv.material3.Text

@Composable
fun MyDrawer(
    modifier: Modifier = Modifier,
    rootNavController: NavHostController,
    bottomBarNavController: NavHostController,
    content: @Composable () -> Unit
) {
    ModalNavigationDrawer(
//        modifier = modifier.background(Color.Black),
        drawerContent = {
            Log.wtf("test", "ModalNavigationDrawer drawerContent")
            val focusRequester = remember { FocusRequester() }

            Column(
                modifier = Modifier.fillMaxHeight()
                    .background(Color.Black),
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
        },
        content = content
    )
}

@Composable
fun NavigationItem(
    drawerValue: DrawerValue,
    color: ImageVector,
    text: String,
    selected: () -> Unit
) {
    OutlinedButton(
        modifier = Modifier
            .padding(16.dp)
            .wrapContentWidth(),
        onClick = { selected() }
    ) {
        Icon(
            imageVector = color,
            contentDescription = null,
            modifier = Modifier.padding(end = 4.dp),
            tint = Color.White
        )
        AnimatedVisibility(visible = drawerValue == DrawerValue.Open) {
            Text(
                modifier = Modifier.padding(end = 4.dp),
                text = text,
                softWrap = false,
                textAlign = TextAlign.Start,
                color = Color.White
            )
        }
    }
}