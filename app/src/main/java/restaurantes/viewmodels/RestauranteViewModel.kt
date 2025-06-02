package restaurantes.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import restaurantes.RestauranteApiService
import restaurantes.RestauranteRepository
import restaurantes.models.Restaurante
import retrofit2.HttpException
import java.io.IOException



class RestauranteViewModel : ViewModel() {

    private val apiService = RestauranteApiService.create()
    private val repository = RestauranteRepository(apiService)

    private val _restaurantes = MutableStateFlow<List<Restaurante>>(emptyList())
    val restaurantes = _restaurantes.asStateFlow()

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    init {
        loadRestaurantes()
    }

    private fun loadRestaurantes() {
        viewModelScope.launch {
            try {
                _restaurantes.value = repository.fetchRestaurantes()
            } catch (e: HttpException) {
                _errorMessage.value = when (e.code()) {
                    404 -> Log.d("Error 404", "Recurso no encontrado").toString()
                    500 -> Log.d("Error 500", "Error del servidor").toString()
                    else -> Log.d("Error HTTP", "${e.code()}").toString()
                }
            } catch (e: IOException) {
                _errorMessage.value = Log.d("Sin conexión","Sin conexión a internet").toString()
            } catch (e: Exception) {
                _errorMessage.value = Log.d("Error desconocido","${e.localizedMessage}").toString()
            }
        }
    }
}