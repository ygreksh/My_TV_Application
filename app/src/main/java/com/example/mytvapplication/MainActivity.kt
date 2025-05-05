package com.example.mytvapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.tv.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Surface
import com.example.mytvapplication.ui.theme.MyBlue
import com.example.mytvapplication.ui.theme.MyGreen
import com.example.mytvapplication.ui.theme.MyTVApplicationTheme
import com.example.mytvapplication.ui.theme.MyTVBlack
import com.example.mytvapplication.ui.theme.MyTVWhite
import com.example.mytvapplication.ui.theme.Purple40

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalTvMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTVApplicationTheme {
                Surface(
                    shape = RectangleShape,
                    modifier = Modifier
                        .fillMaxSize()
//                        .background(MyBlue)
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(MyTVBlack)
    ) {
        Text(
            text = "Hello $name!",
            color = MyTVWhite,
//            color = MyGreen,
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyTVApplicationTheme {
        Greeting("Android")
    }
}