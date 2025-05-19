package com.example.mobile1project.thirdpartial

import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.mobile1project.navigation.ScreenNavigation

@Composable
fun ThirdPartialView(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Tercer Parcial",
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = { navController.navigate(ScreenNavigation.Student.route) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ir a lista de estudiantes")
        }

        Button(
            onClick = { navController.navigate(ScreenNavigation.Locations.route) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ir a lista de ubicaciones")
        }

        Button(
            onClick = { navController.navigate(ScreenNavigation.Estudiantes.route) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Mostrar estudiantes")
        }
    }
}