package com.example.compositebuildsample.feature.list

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import com.example.compositebuildsample.feature.detail.navigation.navigateToDetail

@Composable
internal fun ListScreenRoute(navController: NavController) {
    ListScreen(navController = navController)
}

@Composable
fun ListScreen(navController: NavController) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "ListScreen")
        Button(onClick = {
            navController.navigateToDetail()
        }) {
            Text(text = "to detailScreen")
        }
    }
}