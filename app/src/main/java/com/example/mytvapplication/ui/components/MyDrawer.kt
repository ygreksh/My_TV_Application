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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
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
    selectedId: String = "home",
    focusRequester: FocusRequester,
    onSelectItem: (String) -> Unit,
    content: @Composable () -> Unit
) {
    Log.wtf("test", "start MyDrawer")

    val menuList = listOf("home", "movies", "tv", "search", "settings")
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
//    var currentFocuseditem by remember { mutableStateOf(0) }
//    var currentselectedId by remember { mutableStateOf(selectedId) }

    ModalNavigationDrawer(
//        modifier = modifier.background(Color.Black),
        drawerState = drawerState,
        drawerContent = {
            Log.wtf("test", "ModalNavigationDrawer drawerContent: selectedId = $selectedId")
//            val focusRequester = remember { FocusRequester() }

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
                        menuItemId = menuItem,
//                        isFocused = (index == currentFocuseditem),
                        isSelected = menuItem == selectedId,
                        focusRequester = focusRequester,
//                        isFocused = false
//                        onSelect = onSelectItem()
                    ) {
                        Log.wtf("mainMenu", "onClick $menuItem, index = $index")
//                        currentFocuseditem = index
                        onSelectItem(menuItem)
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
    menuItemId: String,
    isFocused: Boolean = false,
    isSelected: Boolean = false,
    focusRequester: FocusRequester,
    onSelect: () -> Unit
) {
//    val focusRequester = remember { FocusRequester() }
    val navItemFocusRequester = remember { FocusRequester() }

    val currItemId = menuItemId
//    Log.wtf("test", "draw NavigationItem $text, isSelected = $isSelected, drawerValue = $drawerValue")

//    if (DrawerValue.Open)

//    LaunchedEffect(true) {
//        Log.wtf("test", "NavigationItem LaunchedEffect(Unit) isSelected = $isSelected, drawerValue = $drawerValue")
        if (isSelected && drawerValue == DrawerValue.Open) {
            Log.wtf("test", "set focus on $text")
//            navItemFocusRequester.requestFocus()
//            focusRequester.requestFocus()
        }
//    }

    OutlinedButton(
        modifier = Modifier
            .focusRequester(if (isSelected && drawerValue == DrawerValue.Open) focusRequester else navItemFocusRequester)
//            .focusRequester(navItemFocusRequester)
            .padding(16.dp)
            .wrapContentWidth(),
        onClick = { onSelect() }
    ) {
        Icon(
            imageVector = color,
            contentDescription = null,
            modifier = Modifier.padding(end = 4.dp),
            tint = if (isSelected) Color.Red else Color.White
        )
        AnimatedVisibility(visible = drawerValue == DrawerValue.Open) {
            Text(
                modifier = Modifier.padding(end = 4.dp),
                text = text,
                softWrap = false,
                textAlign = TextAlign.Start,
                color = if (isSelected) Color.Red else Color.White
            )
        }
    }
}