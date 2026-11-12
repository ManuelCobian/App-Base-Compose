package com.luvsoft.kotlinecommerce.presentation.navigations.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.luvsoft.ecommercekt.presentation.navigations.graph.authNavGraph
import com.luvsoft.kotlinecommerce.presentation.navigations.Graph


/* ESTE EL GRAFO QUE SE UTILIZA PARA TODA LA APLICACION DONDE TIENE EL LOGIN Y EL REGISTRO DENTRO DE UN SOLO GRAFO
* SI QUIERO Agregar el admin modulo se crea otro grafo y se agrega a este grafo
* */

@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTHENTICATION
    ) {
        authNavGraph(navController = navController)
    }
}