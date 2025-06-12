package com.example.mytvapplication.ui.screens.main.tv.Programs

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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.tv.material3.Button
import androidx.tv.material3.Text
import com.example.mytvapplication.ui.screens.Screens

@Composable
fun Programs2Screen(
    rootNavController: NavController,
    navController: NavHostController,
    viewModel: ProgramsViewModel = hiltViewModel()
) {
    Log.wtf("test", "start Programs2Screen")
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
                text = "Programs2Screen",
                color = Color.White
            )

            Button(
                onClick = { Log.wtf("test", "Programs2Screen Program onClick()")},
                modifier = Modifier
                    .focusRequester(focusRequester)
                    .onKeyEvent{
                        if(
                            it.type == KeyEventType.KeyDown &&
                            it.key == Key.DirectionLeft
                        ) {
                            Log.wtf("test", "Program1 click LEFT")
                            navController.navigate(Screens.Main.TV.Channels.route)
                            true
                        } else {
                            false
                        }
                    }
            ) {
                Text(
                    text = "Program 1",
                    color = Color.White
                )
            }
        }
    }
}