package com.example.aplicacionlibre

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.aplicacionlibre.ui.theme.AplicacionLibreTheme
import ui.AppScaffold

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AplicacionLibreTheme {
                AppScaffold {
                    Box(
                        Modifier.fillMaxSize(),
                        Alignment.Center
                    ) {
                        Text("Bienvenido a la App de Jetpack Compose")
                    }
                }
            }
        }
    }
}


