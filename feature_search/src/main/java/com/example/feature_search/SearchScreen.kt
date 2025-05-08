package com.example.feature_search

import androidx.compose.ui.graphics.Color
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.tv.material3.Text

@Composable
fun SearchScreen(
    rootNavController: NavController,
) {
    Log.wtf("test", "start SearchScreen")

    Text(
        text = "SearchScreen",
        color = Color.White
    )
}