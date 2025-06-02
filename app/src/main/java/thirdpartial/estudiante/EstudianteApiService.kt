package thirdpartial.estudiante

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import thirdpartial.estudiante.models.Estudiante

interface EstudianteApiService {
    @GET("2b6648feaf70d1116e6f468b263d73c9/raw/50cf034eb87e273d6746cf2ffb9afb5a409f80b2/students.json")
    suspend fun getEstudiantes(): List<Estudiante>
    companion object {
        private const val BASE_URL = "https://gist.githubusercontent.com/ingjromo/"

        fun create(): EstudianteApiService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(EstudianteApiService::class.java)
        }
    }
}