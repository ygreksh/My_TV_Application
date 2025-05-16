package com.example.mytvapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.tv.material3.ExperimentalTvMaterial3Api
import com.example.mytvapplication.ui.theme.MyTVApplicationTheme
import com.example.mytvapplication.ui.navigation.RootNavGraph

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


//@Preview(showBackground = true)
//@Composable
//fun DrawerPreview() {
//    MyNavigationDrawer()
//
//}