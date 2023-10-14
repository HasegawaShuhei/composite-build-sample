package com.example.compositebuildsample.feature.detail.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.compositebuildsample.feature.detail.DetailScreenRoute

const val detailRoute = "detail_route"

fun NavController.navigateToDetail(navOptions: NavOptions? = null) {
    this.navigate(detailRoute, navOptions)
}

fun NavGraphBuilder.detailScreen() {
    composable(route = detailRoute) {
        DetailScreenRoute()
    }
}