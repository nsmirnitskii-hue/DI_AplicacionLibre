package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.aplicacionlibre.AppViewModel


@Composable
fun ColorPickerScreen(vm: AppViewModel, navController: NavController) {
    AppScaffold(title = "Inicio", navController = navController) {
    val colors = listOf(Color.Red, Color.Green, Color.Blue, Color.Yellow, Color.Magenta)

    Column(Modifier.fillMaxSize().padding(16.dp)) {

        Text("Selector de Color", style = MaterialTheme.typography.headlineMedium)

        Box(
            Modifier
                .size(150.dp)
                .background(vm.selectedColor.value)
                .padding(16.dp)
        )

        Row(Modifier.padding(top = 16.dp)) {
            colors.forEach { color ->
                Box(
                    Modifier
                        .size(50.dp)
                        .padding(4.dp)
                        .background(color)
                        .clickable { vm.selectedColor.value = color }
                )
            }
        }
    }
        }
}