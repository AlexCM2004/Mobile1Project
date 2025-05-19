package thirdpartial.estudiante.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import retrofit2.HttpException
import java.io.IOException
import thirdpartial.estudiante.models.Estudiante
import thirdpartial.estudiante.EstudianteRepository
import thirdpartial.estudiante.EstudianteApiService


class EstudianteViewModel : ViewModel() {

    private val apiService = EstudianteApiService.create()
    private val repository = EstudianteRepository(apiService)

    private val _estudiantes = MutableStateFlow<List<Estudiante>>(emptyList())
    val estudiantes = _estudiantes.asStateFlow()

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    init {
        loadEstudiantes()
    }

    private fun loadEstudiantes() {
        viewModelScope.launch {
            try {
                _estudiantes.value = repository.fetchEstudiantes()
            } catch (e: HttpException) {
                _errorMessage.value = when (e.code()) {
                    404 -> "Recurso no encontrado (404)"
                    500 -> "Error del servidor (500)"
                    else -> "Error HTTP: ${e.code()}"
                }
            } catch (e: IOException) {
                _errorMessage.value = "Sin conexión a internet"
            } catch (e: Exception) {
                _errorMessage.value = "Error desconocido: ${e.localizedMessage}"
            }
        }
    }
}