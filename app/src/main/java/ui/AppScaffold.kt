package ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.aplicacionlibre.R
import kotlinx.coroutines.launch



sealed class Screen(val route: String) {
    object Inicio : Screen("Inicio")
    object Galeria : Screen("Galeria")
    object Tareas : Screen("Tareas")
    object Colores : Screen("Colores")
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScaffold() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val navController = rememberNavController() // Solo una vez aquí

    // Obtener la ruta actual
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                Modifier.padding(horizontal = 16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Spacer(Modifier.height(12.dp))
                Text(
                    "Aplicación Libre",
                    Modifier.padding(16.dp),
                    style = MaterialTheme.typography.titleLarge
                )
                HorizontalDivider()

                NavigationDrawerItem(
                    label = { Text("Inicio") },
                    selected = currentRoute == "Home",
                    onClick = {
                        navController.navigate("Home") {
                            // Esto evita múltiples copias de la misma pantalla
                            popUpTo("Home") { inclusive = true }
                        }
                        scope.launch { drawerState.close() }
                    }
                )
                NavigationDrawerItem(
                    label = { Text("Galería") },
                    selected = currentRoute == "gallery",
                    onClick = {
                        navController.navigate("gallery") {
                            launchSingleTop = true
                        }
                        scope.launch { drawerState.close() }
                    }
                )
                NavigationDrawerItem(
                    label = { Text("Tareas") },
                    selected = currentRoute == "tareas",
                    onClick = {
                        navController.navigate("tareas") {
                            launchSingleTop = true
                        }
                        scope.launch { drawerState.close() }
                    }
                )
                NavigationDrawerItem(
                    label = { Text("Colores") },
                    selected = currentRoute == "color",
                    onClick = {
                        navController.navigate("color") {
                            launchSingleTop = true
                        }
                        scope.launch { drawerState.close() }
                    }
                )
                HorizontalDivider()
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Aplicación Libre") },
                    navigationIcon = {
                        IconButton({
                            scope.launch {
                                if (drawerState.isClosed)
                                    drawerState.open() else drawerState.close()
                            }
                        }) {
                            Icon(
                                painter = painterResource(R.drawable.menu),
                                contentDescription = "Menu"
                            )
                        }
                    }
                )
            }
        ) { innerPadding ->
            Navigation(navController = navController, innerPadding = innerPadding)
        }
    }
}