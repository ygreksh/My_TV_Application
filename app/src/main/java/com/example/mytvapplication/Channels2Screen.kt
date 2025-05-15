package com.example.mytvapplication

import android.util.Log
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
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.key.type
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.tv.material3.Button
import androidx.tv.material3.Text

@Composable
fun Channels2Screen(
//    rootNavController: NavController,
    navController: NavHostController
) {
    Log.wtf("test", "start Channels2Screen")
    val focusRequester = remember { FocusRequester() }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        LaunchedEffect(Unit) {
            focusRequester.requestFocus()
        }
        Column(
        ) {
            Text(
                text = "Channels2Screen",
                color = Color.White
            )

            Button(
                onClick = {
//                    Log.wtf("test", "Channels2Screen Channel1 onClick()")
                          },
                modifier = Modifier
                    .focusRequester(focusRequester)
                    .onKeyEvent{
                    if(
                        it.type == KeyEventType.KeyDown &&
                        it.key == Key.DirectionRight
                    ) {
                        Log.wtf("test", "Channel1 click RIGHT")
                        navController.navigate(Screens.Main.TV.Programs.route)
                        true
                    } else {
                        false
                    }
                }
            ) {
                Text(
                    text = "Channel 1",
                    color = Color.White
                )
            }
        }
    }
}