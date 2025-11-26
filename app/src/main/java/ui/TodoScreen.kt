package ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.aplicacionlibre.AppViewModel


@Composable
fun TodoScreen(vm: AppViewModel, navController: NavController) {
    AppScaffold() {
        var text by remember { mutableStateOf("") }

        Column(Modifier.fillMaxSize().padding(16.dp)) {
            Text("Lista de tareas", style = MaterialTheme.typography.headlineMedium)

            Row {
                TextField(
                    value = text,
                    onValueChange = { text = it },
                    modifier = Modifier.weight(1f)
                )
                Button(
                    onClick = {
                        if (text.isNotEmpty()) vm.todoList.add(text)
                        text = ""
                    }
                ) {
                    Text("Añadir")
                }
            }

            LazyColumn {
                items(vm.todoList) { item ->
                    Text("• $item", Modifier.padding(4.dp))
                }
            }
        }
    }
}