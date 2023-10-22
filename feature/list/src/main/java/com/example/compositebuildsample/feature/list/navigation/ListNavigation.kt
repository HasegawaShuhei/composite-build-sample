package com.example.compositebuildsample.feature.list.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.compositebuildsample.feature.list.ListScreenRoute

const val LIST_ROUTE = "list_route"

fun NavController.navigateToList(memoId: Int, navOptions: NavOptions? = null) {
    this.navigate(LIST_ROUTE, navOptions)
}

fun NavGraphBuilder.listScreen(navController: NavController) {
    composable(route = LIST_ROUTE) {
        ListScreenRoute(navController = navController)
    }
}