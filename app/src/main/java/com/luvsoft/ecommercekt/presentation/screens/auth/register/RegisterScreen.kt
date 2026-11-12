package com.luvsoft.kotlinecommerce.presentation.screens.auth.register

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.luvsoft.base.ui.componets.DefaultTopBar
import com.luvsoft.base.ui.theme.KotlinEcommerceTheme
import com.luvsoft.ecommercekt.presentation.screens.auth.register.componets.RegisterContent

@Composable
fun RegisterScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Registro",
                upAvailable = true,
                navController = navController
            )
        }
    ){ paddingValues ->
        RegisterContent(paddingValues, navController)
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun RegisterScreenPreview() {
    KotlinEcommerceTheme {
        RegisterContent(
            paddingValues = PaddingValues(),
            navController = NavHostController(LocalContext.current)
        )
    }
}