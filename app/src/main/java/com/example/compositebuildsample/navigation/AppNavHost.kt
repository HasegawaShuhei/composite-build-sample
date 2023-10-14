package com.example.compositebuildsample.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import com.example.compositebuildsample.feature.detail.navigation.detailScreen
import com.example.compositebuildsample.feature.list.navigation.listRoute
import com.example.compositebuildsample.feature.list.navigation.listScreen

@Composable
fun AppNavHost(navController: NavHostController, startDestination: String = listRoute) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        listScreen()
        detailScreen()
    }
}