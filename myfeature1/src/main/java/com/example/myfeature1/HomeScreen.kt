package com.example.myfeature1

import androidx.compose.foundation.background
import androidx.compose.foundation.focusGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.VideoLibrary
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.tv.material3.DrawerValue
import androidx.tv.material3.Icon
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.ModalNavigationDrawer
import androidx.tv.material3.NavigationDrawerItem
import androidx.tv.material3.Text


@Composable
fun HomeScreen(
) {
    MyNavigationDrawer()
}


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MyNavigationDrawer(
    modifier: Modifier = Modifier
) {
    val (discover, library) = remember { FocusRequester.createRefs() }
    val currentRoute = remember { "home" }

    ModalNavigationDrawer(
        modifier = modifier.background(Color.Black),
        drawerContent = {
            val isClosed = it == DrawerValue.Closed
            Column(
                modifier = Modifier
                    .padding(all = 5.dp)
                    .focusProperties {
                        enter = {
                            when (currentRoute) {
                                "home" -> discover
                                "settings" -> library
                                else -> FocusRequester.Default
                            }
                        }
                    }
                    .focusGroup()
            ) {

                NavigationDrawerItem(
                    selected = isClosed && currentRoute == "account",
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


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}