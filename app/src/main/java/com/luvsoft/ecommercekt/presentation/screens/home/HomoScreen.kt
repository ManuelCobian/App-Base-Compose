package com.luvsoft.ecommercekt.presentation.screens.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navHostController: NavHostController){

    Scaffold() { paddingValues ->
        Text(
            modifier = Modifier.padding(paddingValues),
            text = "HOLA ESTO ES HOME"
        )
    }
}