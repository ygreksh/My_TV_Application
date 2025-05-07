package com.example.mytvapplication

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.tv.material3.Text

@Composable
fun StartAppScreen(
    rootNavController: NavController,
) {
    Text(text = "StartAppScreen")
}