package com.example.aplicacionlibre

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class AppViewModel : ViewModel() {

    var selectedColor = mutableStateOf(Color.Red)

    var gallerySelection = mutableStateOf(0)

    var todoList = mutableStateListOf<String>()
}