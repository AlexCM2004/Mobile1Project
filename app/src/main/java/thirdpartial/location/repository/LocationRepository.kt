package thirdpartial.location.repository

import thirdpartial.location.models.Location
import thirdpartial.location.ui.LocationApiService

class LocationRepository(private val apiService: LocationApiService) {
    suspend fun fetchLocations(): List<Location> {
        return apiService.getLocations()
    }
}