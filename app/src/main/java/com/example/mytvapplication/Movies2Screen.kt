package com.example.mytvapplication

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.tv.material3.Button
import androidx.tv.material3.Text

@Composable
fun Movies2Screen(
//    rootNavController: NavController,
    navController: NavHostController
) {
    Log.wtf("test", "start Movies2Screen")

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
//        Text(
//            text = "Movies2Screen",
//            color = Color.White
//        )

        Column(
        ) {
            Text(
                text = "Movies2Screen",
                color = Color.White
            )

            Button(
                onClick = { Log.wtf("test", "Button1 onClick()")}
            ) {
                Text(
                    text = "Button 1",
                    color = Color.White
                )
            }
        }
    }
}