package com.example.mytvapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
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
import androidx.tv.material3.Icon
import androidx.tv.material3.Surface
import com.example.mytvapplication.ui.theme.MyBlue
import com.example.mytvapplication.ui.theme.MyGreen
import com.example.mytvapplication.ui.theme.MyTVApplicationTheme
import com.example.mytvapplication.ui.theme.MyTVBlack
import com.example.mytvapplication.ui.theme.MyTVWhite
import com.example.mytvapplication.ui.theme.Purple40
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.rememberNavController
import androidx.tv.material3.DrawerValue
import androidx.tv.material3.ModalNavigationDrawer
import androidx.tv.material3.OutlinedButton
import com.example.mylibrary.navigateToAccount

//import com.example.mylibrary.navigateToAccount

//import com.example.mytvapplication.feature.navigateToHome
//import com.example.myfeature1.ui.navigateToHome

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalTvMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTVApplicationTheme {
                RootNavGraph()

//                Surface(
//                    shape = RectangleShape,
//                    modifier = Modifier
//                        .fillMaxSize()
////                        .background(MyBlue)
//                ) {
////                    Greeting("Android")
//
//                    MyNavigationDrawer(
//
//                    )
//
//                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DrawerPreview() {
    MyNavigationDrawer()

}


@Composable
fun NavigationItem(
    drawerValue: DrawerValue,
    color: ImageVector,
    text: String,
    selected: () -> Unit
) {
    OutlinedButton(
        modifier = Modifier
            .padding(16.dp)
            .wrapContentWidth(),
        onClick = { selected() }
    ) {
        Icon(
            imageVector = color,
            contentDescription = null,
            modifier = Modifier.padding(end = 4.dp),
            tint = Color.White
        )
        AnimatedVisibility(visible = drawerValue == DrawerValue.Open) {
            Text(
                modifier = Modifier.padding(end = 4.dp),
                text = text,
                softWrap = false,
                textAlign = TextAlign.Start,
                color = Color.White
            )
        }
    }
}

@Composable
fun MyNavigationDrawer(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
//    navController.navigateToHome()

    ModalNavigationDrawer(
        modifier = modifier.background(Color.Black),
        drawerContent = {
            Log.wtf("test", "ModalNavigationDrawer drawerContent")
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                NavigationItem(it, Icons.Default.Home, "Home") {
                    Log.wtf("mainMenu", "onClick Home")
                }
                NavigationItem(it, Icons.Default.Menu, "Movies") {
                    Log.wtf("mainMenu", "onClick Movies")
                }
                NavigationItem(it, Icons.Default.Email, "TV Shows") {
                    Log.wtf("mainMenu", "onClick TV Shows")
                }
                NavigationItem(it, Icons.Default.Settings, "Settings") {
                    Log.wtf("mainMenu", "onClick Settings")
//                    navController.navigateToAccount()
                    navController.navigate("account")
                }
            }
        }
    ) { }
}