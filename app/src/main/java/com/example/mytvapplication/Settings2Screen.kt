package com.example.mytvapplication

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.tv.material3.Text

@Composable
fun Settings2Screen(
    rootNavController: NavController,
) {
    Log.wtf("test", "start Settings2Screen")

    Text(
        text = "Settings2Screen",
        color = Color.White
    )
}