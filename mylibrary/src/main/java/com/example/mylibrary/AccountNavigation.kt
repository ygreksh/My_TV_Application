package com.example.mylibrary

import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navDeepLink
import kotlinx.serialization.Serializable


@Serializable
data object AccountRoute // route to Account screen
@Serializable
data object AccountBaseRoute // route to base navigation graph

fun NavController.navigateToAccount() = navigate(route = "account")

fun NavGraphBuilder.AccountSection(
    onTopicClick: (String) -> Unit,
    topicDestination: NavGraphBuilder.() -> Unit,
) {
    navigation<AccountBaseRoute>(startDestination = AccountRoute) {
        Log.d("test", "NavGraphBuilder.AccountSection")
//        composable<AccountRoute>(
//            deepLinks = listOf(
//                navDeepLink {
//                    uriPattern = "___"
//                },
//            ),
//        ) {
//            AccountScreen()
//            Log.d("test", "NavGraphBuilder.AccountSection")
//        }
//        topicDestination()
    }
}
