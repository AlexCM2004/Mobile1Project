package com.example.mobile1project.ids.fahrenheit.viewmodels

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.example.mobile1project.R

class FahrenheitViewModel : ViewModel(){
    var celsius by mutableStateOf(TextFieldValue(""))
    var resultado by mutableStateOf(0)

    fun calcularFahrenheit() {
        val cels = celsius.text.toIntOrNull() ?: 0
        resultado = (cels * 9/5) + 32
    }
}