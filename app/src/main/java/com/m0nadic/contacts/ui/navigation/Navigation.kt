package com.m0nadic.contacts.ui.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.m0nadic.contacts.data.network.Supabase
import com.m0nadic.contacts.data.repository.SupabaseAuthRepository
import com.m0nadic.contacts.ui.screen.dashboard.DashboardScreen
import com.m0nadic.contacts.ui.screen.signin.SignInScreen
import com.m0nadic.contacts.ui.screen.signup.SignUpScreen
import com.m0nadic.contacts.ui.viewmodel.SignInViewModel
import com.m0nadic.contacts.ui.viewmodel.SignUpViewModel
import com.m0nadic.contacts.util.AuthStateHolder
import com.m0nadic.contacts.util.AuthStateHolderImpl
import io.github.jan.supabase.gotrue.auth

@Composable
fun Navigation(context: Context) {
    val navigationController = rememberNavController()
    val signUpViewModel = SignUpViewModel(SupabaseAuthRepository(Supabase.client.auth), AuthStateHolderImpl(context))
    val signInViewModel = SignInViewModel(SupabaseAuthRepository(Supabase.client.auth), AuthStateHolderImpl(context))
    val authState = AuthStateHolderImpl(context)

    NavHost(navController = navigationController, startDestination = Routes.DASHBOARD) {
        composable(Routes.LOGIN) {
            SignInScreen(navigationController, signInViewModel)
        }

        composable(Routes.SIGNUP) {
            SignUpScreen(navigationController, signUpViewModel)
        }

        composable(Routes.LOGOUT) {
            Logout(navigationController, authState)
        }

        composable(Routes.DASHBOARD) {
            Protected(navController = navigationController, authState) {
                DashboardScreen(navigationController)
            }
        }

    }
}

@Composable
fun Logout(navigationController: NavHostController, authState: AuthStateHolder) {
    authState.setLoggedIn(false)
    navigationController.navigate(Routes.DASHBOARD)
}

@Composable
fun Protected(
    navController: NavHostController,
    authState: AuthStateHolder,
    content: @Composable (NavHostController) -> Unit
) {
    if (authState.isLoggedIn()) {
        content(navController)
    } else {
        navController.navigate("login") {
            popUpTo(navController.graph.startDestinationRoute.toString()) {
                saveState = true
            }
            launchSingleTop = true
        }
    }
}