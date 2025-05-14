package com.example.mytvapplication

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.tv.material3.Button
import androidx.tv.material3.Text

@Composable
fun Home2Screen(
//    rootNavController: NavController,
    navController: NavHostController
) {
    Log.wtf("test", "start Home2Screen")
    val focusRequester = remember { FocusRequester() }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
//            .background(Color.DarkGray)
    ) {
//        Text(
//            text = "Home2Screen",
//            color = Color.White,
//            modifier = Modifier.focusable()
//        )
        LaunchedEffect(Unit) {
            focusRequester.requestFocus()
        }

        Column(
        ) {
            Text(
                text = "Home2Screen",
                color = Color.White
            )

            Button(
                onClick = { Log.wtf("test", "HomeScreen Button1 onClick()") },
                modifier = Modifier.focusRequester(focusRequester)
            ) {
//                LaunchedEffect(Unit) {
//                    focusRequester.requestFocus()
//                }

                Text(
                    text = "Button 1",
                    color = Color.White
                )
            }
            Button(
                onClick = { Log.wtf("test", "HomeScreen Button2 onClick()") }
            ) {
                Text(
                    text = "Button 2",
                    color = Color.White
                )
            }
            Button(
                onClick = { Log.wtf("test", "HomeScreen Button3 onClick()") }
            ) {
                Text(
                    text = "Button 3",
                    color = Color.White
                )
            }
        }
    }
}