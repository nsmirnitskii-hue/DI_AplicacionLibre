package ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.aplicacionlibre.AppViewModel


@Composable
fun GalleryScreen(vm: AppViewModel, navController: NavController) {
    AppScaffold(title = "Galería", navController = navController) {
        val images = listOf(
            painterResource(android.R.drawable.ic_menu_camera),
            painterResource(android.R.drawable.ic_menu_gallery),
            painterResource(android.R.drawable.ic_menu_report_image)
        )

        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Galería", style = MaterialTheme.typography.headlineMedium)

            Image(
                painter = images[vm.gallerySelection.value],
                contentDescription = null,
                modifier = Modifier.size(200.dp).padding(16.dp)
            )

            Row {
                images.forEachIndexed { index, _ ->
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .padding(4.dp)
                            .background(
                                if (vm.gallerySelection.value == index)
                                    Color.Gray else Color.LightGray
                            )
                            .clickable { vm.gallerySelection.value = index }
                    )
                }
            }
        }
    }
}