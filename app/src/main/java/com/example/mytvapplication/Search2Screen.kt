package com.example.mytvapplication

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.tv.material3.Text

@Composable
fun Search2Screen(
//    rootNavController: NavController,
    navController: NavHostController
) {
    Log.wtf("test", "start Search2Screen")

    Text(
        text = "Search2Screen",
        color = Color.White
    )
}