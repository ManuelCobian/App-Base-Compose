package com.luvsoft.ecommercekt.presentation.screens.auth.login

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.luvsoft.ecommercekt.presentation.navigations.screen.AuthScreen
import com.luvsoft.ecommercekt.presentation.screens.auth.login.componets.LoginContent
import com.luvsoft.ecommercekt.presentation.screens.auth.login.componets.Login

/*
* Este contiene la pantalla de login qe llamma el grafo de autenticacion y muestra su contenido
*  */
@Composable
fun LoginScreen(navController: NavHostController) {
    Scaffold(){ paddingValues ->
        LoginContent(paddingValues, navController)
    }
    Login(navController)
}

