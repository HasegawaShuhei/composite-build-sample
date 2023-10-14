package com.example.compositebuildsample.feature.list.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.compositebuildsample.feature.list.ListScreenRoute

const val listRoute = "list_route"

fun NavController.navigateToList(navOptions: NavOptions? = null) {
    this.navigate(listRoute, navOptions)
}

fun NavGraphBuilder.listScreen(navController: NavController) {
    composable(route = listRoute) {
        ListScreenRoute(navController = navController)
    }
}