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


//@Composable
//fun NavigationItem(
//    drawerValue: DrawerValue,
//    color: ImageVector,
//    text: String,
//    selected: () -> Unit
//) {
//    OutlinedButton(
//        modifier = Modifier
//            .padding(16.dp)
//            .wrapContentWidth(),
//        onClick = { selected() }
//    ) {
//        Icon(
//            imageVector = color,
//            contentDescription = null,
//            modifier = Modifier.padding(end = 4.dp),
//            tint = Color.White
//        )
//        AnimatedVisibility(visible = drawerValue == DrawerValue.Open) {
//            Text(
//                modifier = Modifier.padding(end = 4.dp),
//                text = text,
//                softWrap = false,
//                textAlign = TextAlign.Start,
//                color = Color.White
//            )
//        }
//    }
//}

//@Composable
//fun MyNavigationDrawer(
//    modifier: Modifier = Modifier
//) {
//    val navController = rememberNavController()
////    navController.navigateToHome()
//
//    ModalNavigationDrawer(
//        modifier = modifier.background(Color.Black),
//        drawerContent = {
//            Log.wtf("test", "ModalNavigationDrawer drawerContent")
//            Column(
//                modifier = Modifier.fillMaxHeight(),
//                verticalArrangement = Arrangement.Center
//            ) {
//                NavigationItem(it, Icons.Default.Home, "Home") {
//                    Log.wtf("mainMenu", "onClick Home")
//                }
//                NavigationItem(it, Icons.Default.Menu, "Movies") {
//                    Log.wtf("mainMenu", "onClick Movies")
//                }
//                NavigationItem(it, Icons.Default.Email, "TV Shows") {
//                    Log.wtf("mainMenu", "onClick TV Shows")
//                }
//                NavigationItem(it, Icons.Default.Settings, "Settings") {
//                    Log.wtf("mainMenu", "onClick Settings")
////                    navController.navigateToAccount()
//                    navController.navigate("account")
//                }
//            }
//        }
//    ) { }
//}