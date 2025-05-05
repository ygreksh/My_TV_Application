package com.example.mytvapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.tv.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Button
import androidx.tv.material3.ButtonBorder
import androidx.tv.material3.ButtonColors
import androidx.tv.material3.ButtonDefaults
import androidx.tv.material3.ButtonGlow
import androidx.tv.material3.ButtonScale
import androidx.tv.material3.ButtonShape
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
//            .fillMaxSize()
            .background(MyTVBlack)
    ) {
        Column {
            Text(
                text = "Hello $name!",
                color = MyTVWhite,
                modifier = modifier
//                modifier = Modifier
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
            TvButton(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp),
                onClick = { Log.d("test", "Button 3 onClick") },
            ) {
                Text(
//                    modifier = Modifier.fillMaxWidth(),
                    text = "LOGIN",
                    style = TextStyle(
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Light,
                        textAlign = TextAlign.Center,
                    ),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyTVApplicationTheme {
        Greeting("Android")
    }
}

@Composable
fun TvButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    scale: ButtonScale = ButtonDefaults.scale(),
    glow: ButtonGlow = ButtonDefaults.glow(),
    shape: ButtonShape = ButtonDefaults.shape(),
    colors: ButtonColors = ButtonDefaults.colors(),
    tonalElevation: Dp = 0.dp,
    border: ButtonBorder = ButtonDefaults.border(),
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        scale = scale,
        glow = glow,
        shape = shape,
        colors = colors,
        tonalElevation = tonalElevation,
        border = border,
        contentPadding = contentPadding,
        interactionSource = interactionSource,
        content = content,
    )
}


//@Composable
//fun FocusingText() {
//    var color by remember { mutableStateOf(Color.Black) }
//    val focusRequester = remember { FocusRequester() }
//    Text(
//        modifier = Modifier
//            .focusRequester(focusRequester)
//            .onFocusChanged { color = if (it.isFocused) Color.Green else Color.Black }
//            .focusable()
//            .pointerInput(Unit) { detectTapGestures { focusRequester.requestFocus() } },
//        text = "Text",
//        color = color
//    )
//}