package com.example.myfeature1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.tv.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myfeature1.ui.theme.MyTVApplicationTheme
import com.example.myfeature1.ui.theme.MyTVBlack
import com.example.myfeature1.ui.theme.MyTVWhite

@Composable
fun MyFeatureGreeting(name: String, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
//            .fillMaxSize()
            .background(MyTVBlack)
    ) {
        Column {
            Text(
                text = "Hello $name!",
                color = MyTVWhite,
//                modifier = modifier
                modifier = Modifier
//                    .focusable()
//                    .clickable { Log.d("test", "Text onClick") }
            )
            Button(
                onClick = { Log.d("test", "Button 1 onClick") }
            ) {
                Text(
                    text = "Button 1",
//                    color = MyTVWhite,
//                    modifier = modifier
                )
            }
            Button(
                onClick = { Log.d("test", "Button 2 onClick") }
            ) {
                Text(
                    text = "Button 2",
                )
            }
            Button(
                onClick = { Log.d("test", "Button 3 onClick") }
            ) {
                Text(
                    text = "Button 3",
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyTVApplicationTheme {
        MyFeatureGreeting("Android")
    }
}