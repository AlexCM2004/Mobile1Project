package restaurantes

import restaurantes.models.Restaurante

class RestauranteRepository(private val apiService: RestauranteApiService) {
    suspend fun fetchRestaurantes(): List<Restaurante> {
        return apiService.getRestaurantes()
    }
}