package com.example.mytvapplication

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.tv.material3.ModalNavigationDrawer
import androidx.tv.material3.Text
import com.example.mylibrary.navigateToAccount

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    rootNavController: NavController,
) {
    Log.wtf("test", "start MainScreen")
//    Text(text = "MainScreen")
//    val navController = rememberNavController()
//    navController.navigateToHome()

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
                }
                NavigationItem(it, Icons.Default.Menu, "Movies") {
                    Log.wtf("mainMenu", "onClick Movies")
                }
                NavigationItem(it, Icons.Default.Email, "TV Shows") {
                    Log.wtf("mainMenu", "onClick TV Shows")
                }
                NavigationItem(it, Icons.Default.Settings, "Settings") {
                    Log.wtf("mainMenu", "onClick Settings")
//                    navController.navigateToAccount()
//                    navController.navigate("account")
                    rootNavController.navigate("account")
                }
            }
        }
    ) { }
}