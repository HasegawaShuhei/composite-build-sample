package com.example.compositebuildsample.feature.detail.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.compositebuildsample.feature.detail.DetailScreenRoute

const val MEMO_ID = "memoId"
const val DETAIL_ROUTE = "detail_route"

fun NavController.navigateToDetail(memoId: Int, navOptions: NavOptions? = null) {
    this.navigate("$DETAIL_ROUTE/${memoId}", navOptions)
}

fun NavGraphBuilder.detailScreen() {
    composable(
        route = "$DETAIL_ROUTE/{$MEMO_ID}",
        arguments = listOf(navArgument(MEMO_ID) { type = NavType.StringType })
    ) {
        DetailScreenRoute()
    }
}