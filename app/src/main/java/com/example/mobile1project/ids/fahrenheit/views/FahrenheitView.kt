package com.example.mobile1project.ids.fahrenheit.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mobile1project.R
import com.example.mobile1project.ids.fahrenheit.viewmodels.FahrenheitViewModel

@Composable
fun FahrenheitView(fahrenheitViewModel: FahrenheitViewModel = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.termometro),
            contentDescription = "Termometro",
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
        )

        TextField(
            value = fahrenheitViewModel.celsius,
            onValueChange = { fahrenheitViewModel.celsius = it },
            label = { Text(stringResource(R.string.celsius)) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { fahrenheitViewModel.calcularFahrenheit() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(R.string.conversion))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(stringResource(R.string.fahrenheit))
        Text("${fahrenheitViewModel.resultado}", style = MaterialTheme.typography.headlineMedium)
    }
}