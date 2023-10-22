package com.example.compositebuildsample.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import com.example.compositebuildsample.feature.detail.navigation.detailScreen
import com.example.compositebuildsample.feature.list.navigation.LIST_ROUTE
import com.example.compositebuildsample.feature.list.navigation.listScreen

@Composable
fun AppNavHost(navController: NavHostController, startDestination: String = LIST_ROUTE) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        listScreen(navController = navController)
        detailScreen()
    }
}