package com.example.aplicacionlibre

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.aplicacionlibre.ui.theme.AplicacionLibreTheme
import ui.ColorPickerScreen
import ui.GalleryScreen
import ui.HomeScreen
import ui.TodoScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AplicacionLibreTheme {
                Navigation()
            }
        }
    }
}

@Composable
fun Navigation() {

    val navController = rememberNavController()
    val vm = viewModel<AppViewModel>()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home") { HomeScreen(navController) }

        composable("gallery") { GalleryScreen(vm, navController) }

        composable("todo") { TodoScreen(vm, navController) }

        composable("colorpicker") { ColorPickerScreen(vm, navController) }
    }
}

