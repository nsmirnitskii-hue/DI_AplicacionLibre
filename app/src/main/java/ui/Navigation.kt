package ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.aplicacionlibre.AppViewModel

@Composable
fun Navigation(navController: NavHostController, innerPadding: PaddingValues) {

    val navController = rememberNavController()
    val vm = viewModel<AppViewModel>()

    NavHost(
        navController = navController,
        startDestination = "Home"
    ) {

        composable("Home") { HomeScreen(navController) }

        composable("gallery") { GalleryScreen(vm, navController) }

        composable("tareas") { TodoScreen(vm, navController) }

        composable("color") { ColorScreen(vm, navController) }
    }
}