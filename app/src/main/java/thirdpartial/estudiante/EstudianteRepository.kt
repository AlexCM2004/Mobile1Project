package thirdpartial.estudiante

import thirdpartial.estudiante.models.Estudiante
import thirdpartial.estudiante.EstudianteApiService

class EstudianteRepository(private val apiService: EstudianteApiService) {
    suspend fun fetchEstudiantes(): List<Estudiante> {
        return apiService.getEstudiantes()
    }
}