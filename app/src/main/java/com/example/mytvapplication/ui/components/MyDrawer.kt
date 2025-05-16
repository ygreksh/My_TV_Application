package com.example.mytvapplication.ui.components

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.tv.material3.DrawerValue
import androidx.tv.material3.Icon
import androidx.tv.material3.ModalNavigationDrawer
import androidx.tv.material3.OutlinedButton
import androidx.tv.material3.Text
import androidx.tv.material3.rememberDrawerState

@Composable
fun MyDrawer(
    modifier: Modifier = Modifier,
    rootNavController: NavHostController,
    bottomBarNavController: NavHostController,
    content: @Composable () -> Unit
) {
    val menuList = listOf("home", "movies", "tv", "search", "settings")
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    var currentFocuseditem by remember { mutableStateOf(0) }

    ModalNavigationDrawer(
//        modifier = modifier.background(Color.Black),
        drawerState = drawerState,
        drawerContent = {
            Log.wtf("test", "ModalNavigationDrawer drawerContent")
            val focusRequester = remember { FocusRequester() }

            LazyColumn(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(Color.Black),
                verticalArrangement = Arrangement.Center
            ) {

                itemsIndexed(menuList) { index, menuItem ->
                    NavigationItem(
                        drawerValue = it,
                        color = Icons.Default.Home,
                        text = menuItem,
                        isFocused = (index == currentFocuseditem),
                        focusRequester = focusRequester
//                        isFocused = false
                    ) {
                        Log.wtf("mainMenu", "onClick $menuItem, index = $index")
                        currentFocuseditem = index
                        bottomBarNavController.navigate(menuItem)
                    }
                }
            }
        },
        scrimBrush = Brush.horizontalGradient(
            listOf(
//                MaterialTheme.colorScheme.surface, Color.Transparent
                Color.Black, Color.Black, Color.Transparent,Color.Transparent, Color.Transparent,
            ),
        ),
        content = content
    )
}

@Composable
fun NavigationItem(
    drawerValue: DrawerValue,
    color: ImageVector,
    text: String,
    isFocused: Boolean = false,
    focusRequester: FocusRequester,
    selected: () -> Unit
) {
//    val focusRequester = remember { FocusRequester() }

    Log.wtf("test", "draw NavigationItem $text, isFocused = $isFocused")

//    LaunchedEffect(Unit) {
//        if (isFocused) {
//            Log.wtf("test", "set focus on $text")
//            focusRequester.requestFocus()
//        }
//    }
    OutlinedButton(
        modifier = Modifier
//            .focusRequester(focusRequester)
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