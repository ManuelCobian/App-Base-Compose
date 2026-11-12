package com.luvsoft.ecommercekt.presentation.screens.auth.login.componets

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.luvsoft.core.domain.utils.Resource
import com.luvsoft.ecommercekt.presentation.navigations.screen.AuthScreen
import com.luvsoft.ecommercekt.presentation.screens.auth.login.LoginViewmodel

@Composable
fun Login(navController: NavHostController, viewmodel: LoginViewmodel = hiltViewModel()) {
    when (val response = viewmodel.loginResponse) {
        is Resource.Loading -> {
            Box(modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is Resource.Success -> {
            LaunchedEffect(Unit) {
                navController.navigate(route = AuthScreen.Home.route)
            }
        }

        is Resource.Failure -> {

        }

        else -> {
            if(response !=null){
                Toast.makeText(LocalContext.current, "Error Desconocido", Toast.LENGTH_LONG).show()
            }
        }
    }
}