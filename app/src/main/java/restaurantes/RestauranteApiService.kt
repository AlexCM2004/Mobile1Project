package restaurantes

import restaurantes.models.Restaurante
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RestauranteApiService {
    @GET("f1c89ab2e409c98ec618fdb9e75077bd/raw/15e41a39c9c251cad31639feabf0ce4ba131bb19/restaurants.json")
    suspend fun getRestaurantes(): List<Restaurante>
    companion object {
        private const val BASE_URL = "https://gist.githubusercontent.com/jorgegit/"

        fun create(): RestauranteApiService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RestauranteApiService::class.java)
        }
    }
}