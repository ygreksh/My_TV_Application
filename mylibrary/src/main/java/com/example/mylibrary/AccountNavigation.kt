package com.example.mylibrary

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navDeepLink
import kotlinx.serialization.Serializable

//class AccountNavigation {
//}

@Serializable
data object AccountRoute // route to Account screen
@Serializable
data object AccountBaseRoute // route to base navigation graph

//fun NavController.navigateToAccount(navOptions: NavOptions) = navigate(route = "Account", navOptions)
fun NavController.navigateToAccount() = navigate(route = "Account")

fun NavGraphBuilder.AccountSection(
    onTopicClick: (String) -> Unit,
    topicDestination: NavGraphBuilder.() -> Unit,
) {
    navigation<AccountBaseRoute>(startDestination = AccountRoute) {
//    navigation(startDestination = AccountRoute) {
        composable<AccountRoute>(
//        composable(
            deepLinks = listOf(
                navDeepLink {
                    /**
                     * This destination has a deep link that enables a specific news resource to be
                     * opened from a notification (@see SystemTrayNotifier for more). The news resource
                     * ID is sent in the URI rather than being modelled in the route type because it's
                     * transient data (stored in SavedStateHandle) that is cleared after the user has
                     * opened the news resource.
                     */
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
//            AccountScreen(onTopicClick)
            AccountScreen()
        }
        topicDestination()
    }
}
