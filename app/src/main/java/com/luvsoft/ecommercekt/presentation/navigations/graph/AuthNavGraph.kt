package com.luvsoft.ecommercekt.presentation.navigations.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.luvsoft.kotlinecommerce.presentation.navigations.Graph
import com.luvsoft.ecommercekt.presentation.navigations.screen.AuthScreen
import com.luvsoft.ecommercekt.presentation.screens.auth.login.LoginScreen
import com.luvsoft.ecommercekt.presentation.screens.home.HomeScreen
import com.luvsoft.kotlinecommerce.presentation.screens.auth.register.RegisterScreen

/*
* Este grafo es unicamente para controlar las pantallas de login y register o tambien el forgetPass
* */
fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthScreen.Login.route,
    ) {
        composable(route = AuthScreen.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(route = AuthScreen.Register.route) {
            RegisterScreen(navController)
        }

        composable(route = AuthScreen.Home.route) {
            HomeScreen(navController)
        }
    }
}