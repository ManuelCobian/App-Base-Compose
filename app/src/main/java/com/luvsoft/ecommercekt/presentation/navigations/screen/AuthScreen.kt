package com.luvsoft.ecommercekt.presentation.navigations.screen


/*
* Esta clase mapea la ruta de cada pantalla de autenticacion que se le envia al grafo de autenticacion
* */
sealed class AuthScreen(val route: String) {
    object Login : AuthScreen("login")
    object Register : AuthScreen("register")

    object Home : AuthScreen("home")
}