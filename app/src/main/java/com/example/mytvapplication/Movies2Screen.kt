package com.example.mytvapplication

import android.R.attr.left
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.tv.material3.Button
import androidx.tv.material3.Text
import com.example.mytvapplication.data.model.Movie

@Composable
fun Movies2Screen(
//    rootNavController: NavController,
    navController: NavHostController
) {
    Log.wtf("test", "start Movies2Screen")

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 100.dp)
    ) {
//        Text(
//            text = "Movies2Screen",
//            color = Color.White
//        )

        Column(
//            modifier = Modifier.padding(40.dp)
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

            LazyRow(
            ) {
                items(5) {
                    MovieCard(
                        movie = Movie(
                            id = "1",
                            posterUri = "https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review/card.jpg",
                            name = "Batman",
                            description = "Batman Serial description"
                        )
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun Movies2ScreenPreview() {
    Movies2Screen(navController = rememberNavController())
}