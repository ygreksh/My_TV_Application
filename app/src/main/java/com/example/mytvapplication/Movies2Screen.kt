package com.example.mytvapplication

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.tv.material3.Text

@Composable
fun Movies2Screen(
//    rootNavController: NavController,
    navController: NavHostController
) {
    Log.wtf("test", "start Movies2Screen")

    Text(
        text = "Movies2Screen",
        color = Color.White
    )
}