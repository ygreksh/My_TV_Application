package com.example.myfeature1.ui

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navDeepLink
import kotlinx.serialization.Serializable

//class HomeNavigation {
//}

@Serializable
data object HomeRoute // route to Home screen
@Serializable
data object HomeBaseRoute // route to base navigation graph

//fun NavController.navigateToHome(navOptions: NavOptions) = navigate(route = "home", navOptions)
fun NavController.navigateToHome() = navigate(route = "home")

fun NavGraphBuilder.HomeSection(
    onTopicClick: (String) -> Unit,
    topicDestination: NavGraphBuilder.() -> Unit,
) {
    navigation<HomeBaseRoute>(startDestination = HomeRoute) {
        composable<HomeRoute>(
            deepLinks = listOf(
                navDeepLink {
                    /**
                     * This destination has a deep link that enables a specific news resource to be
                     * opened from a notification (@see SystemTrayNotifier for more). The news resource
                     * ID is sent in the URI rather than being modelled in the route type because it's
                     * transient data (stored in SavedStateHandle) that is cleared after the user has
                     * opened the news resource.
                     */
//                    uriPattern = DEEP_LINK_URI_PATTERN
                    uriPattern = "__"
                },
            ),
        ) {
//            HomeScreen(onTopicClick)
            HomeScreen()
        }
        topicDestination()
    }
}
