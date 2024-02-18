package com.m0nadic.contacts.ui.screen.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.m0nadic.contacts.ui.navigation.Routes
import com.m0nadic.contacts.ui.theme.ContactsTheme

@Composable
fun DashboardScreen(navigationController: NavHostController) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Dashboard")
        Button(onClick = {
            navigationController.navigate(Routes.LOGOUT)
        }) {
            Text(text = "Log Off")
        }
    }
}

@Preview
@Composable
fun DashboardScreenPreview() {
    ContactsTheme {
        DashboardScreen(rememberNavController())
    }
}