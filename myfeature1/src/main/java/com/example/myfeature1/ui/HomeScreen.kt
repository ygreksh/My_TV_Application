package com.example.myfeature1.ui

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.focusGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.VideoLibrary
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.tv.material3.DrawerValue
import androidx.tv.material3.Icon
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.ModalNavigationDrawer
import androidx.tv.material3.NavigationDrawerItem
import androidx.tv.material3.OutlinedButton
import androidx.tv.material3.Text


@Composable
fun HomeScreen(
) {
    val modifier: Modifier = Modifier

    MyNavigationDrawer(

    )

}


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MyNavigationDrawer(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    val (discover, library) = remember { FocusRequester.createRefs() }
//    val currentRoute by jetcasterAppState.currentRouteFlow.collectAsStateWithLifecycle(initialValue = null)
//    val currentRoute by remember { "home" }
    val currentRoute = remember { "home" }

    ModalNavigationDrawer(
        modifier = modifier.background(Color.Black),
        drawerContent = {
            val isClosed = it == DrawerValue.Closed
            Column(
//                modifier = Modifier.fillMaxHeight(),
//                verticalArrangement = Arrangement.Center
                modifier = Modifier
                    .padding(all = 5.dp)
                    .focusProperties {
                        enter = {
                            when (currentRoute) {
//                                Screen.Discover.route -> discover
//                                Screen.Library.route -> library
                                "home" -> discover
                                "settings" -> library
                                else -> FocusRequester.Default
                            }
                        }
                    }
                    .focusGroup()
            ) {
//                NavigationItem(it, Icons.Default.Home, "Home") {
//
//                }
//                NavigationItem(it, Icons.Default.Menu, "Movies") {
//
//                }
//                NavigationItem(it, Icons.Default.Email, "TV Shows") {
//
//                }
//                NavigationItem(it, Icons.Default.Settings, "Settings") {
//
//                }

                NavigationDrawerItem(
//                    selected = isClosed && currentRoute == Screen.Profile.route,
                    selected = isClosed && currentRoute == "account",
//                    onClick = jetcasterAppState::navigateToProfile,
                    onClick = {},
                    leadingContent = { Icon(Icons.Default.Person, contentDescription = null) },
                ) {
                    Column {
                        Text(text = "Name")
                        Text(
                            text = "Switch Account",
                            style = MaterialTheme.typography.labelSmall
                        )
                    }
                }
                Spacer(modifier = Modifier.weight(1f))
                NavigationDrawerItem(
                    selected = isClosed && currentRoute == "home",
                    onClick = {},
                    leadingContent = {
                        Icon(
                            Icons.Default.Search,
                            contentDescription = null
                        )
                    }
                ) {
                    Text(text = "Search")
                }
                NavigationDrawerItem(
                    selected = isClosed && currentRoute == "search",
                    onClick = {},
                    leadingContent = {
                        Icon(
                            Icons.Default.Home,
                            contentDescription = null
                        )
                    },
                    modifier = Modifier.focusRequester(discover)
                ) {
                    Text(text = "Discover")
                }
                NavigationDrawerItem(
                    selected = isClosed && currentRoute == "discover",
                    onClick = {},
                    leadingContent = {
                        Icon(
                            Icons.Default.VideoLibrary,
                            contentDescription = null
                        )
                    },
                    modifier = Modifier.focusRequester(library)
                ) {
                    Text(text = "Library")
                }
            }
        }
    ) { }
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


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()

}