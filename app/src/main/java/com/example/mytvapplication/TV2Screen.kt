package com.example.mytvapplication

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.tv.material3.Text

@Composable
fun TV2Screen(
    rootNavController: NavController,
) {
    Log.wtf("test", "start TV2Screen")

    Text(
        text = "TV2Screen",
        color = Color.White
    )
}