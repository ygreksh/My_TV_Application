package com.example.mytvapplication.ui.screens.main.movies

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.tv.material3.Button
import androidx.tv.material3.Text
import com.example.mytvapplication.data.model.Movie
import com.example.mytvapplication.data.repository.ApiRepositoryImpl
import com.example.mytvapplication.domain.repository.ApiRepository
import com.example.mytvapplication.domain.usecase.GetLastMoviesUseCase
import com.example.mytvapplication.ui.components.MovieCard

@Composable
fun Movies2Screen(
//    rootNavController: NavController,
    navController: NavHostController
) {
    Log.wtf("test", "start Movies2Screen")

//    var movieListLast : List<Movie> = emptyList()
//    var movieListLast : List<Movie> = remember ()
//    var movieListLast = remember (emptyList())
//    var movieListLast : List<Movie> = remember (listOf())
    var movieListLast by remember { mutableStateOf<List<Movie>>(emptyList()) }
//    var movieListLast = remember { mutableStateOf<List<Movie>>(emptyList()) }


    val apiRepository = ApiRepositoryImpl()
    val getLastMoviesUseCase = GetLastMoviesUseCase(apiRepository = apiRepository)

    LaunchedEffect(Unit) {
        movieListLast = getLastMoviesUseCase.execute()
    }

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
                onClick = { Log.wtf("test", "Button1 onClick()") }
            ) {
                Text(
                    text = "Button 1",
                    color = Color.White
                )
            }

            LazyColumn {
                items(3) {
                    Text(
                        text = "Row Title",
                        color = Color.White
                    )

                    LazyRow(
                        modifier = Modifier
//                            .padding(20.dp)
                    ) {
//                        items(5) {
//                            MovieCard(
//                                movie = Movie(
//                                    id = "1",
//                                    posterUri = "https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review/card.jpg",
//                                    name = "Batman",
//                                    description = "Batman Serial description"
//                                ),
//                                onClick = {
//                                    Log.wtf(
//                                        "test",
//                                        "MovieCard onClick() movie = ${it.name}"
//                                    )
//                                },
////                                modifier = Modifier
////                                    .padding(10.dp)
//                            )
//                        }

                        itemsIndexed(movieListLast) { index, movie ->
                            MovieCard(
                                movie = movie,
                                onClick = {
                                    Log.wtf(
                                        "test",
                                        "MovieCard onClick() movie = ${it.name}"
                                    )
                                },
                            )
                        }

                    }
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