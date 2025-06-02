package restaurantes.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Public
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import restaurantes.models.Restaurante

@Composable
fun RestauranteDetailView(restaurante: Restaurante) {
    val contexto = LocalContext.current
    val imagenResId = remember {
        contexto.resources.getIdentifier(restaurante.imgName, "drawable", contexto.packageName)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = imagenResId),
            contentDescription = "Imagen del restaurante",
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            GoogleMap(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                cameraPositionState = rememberCameraPositionState {
                    position = CameraPosition.fromLatLngZoom(
                        LatLng(restaurante.latitude.toDouble(), restaurante.longitude.toDouble()), 15f
                    )
                }
            ) {
                Marker(
                    state = MarkerState(
                        position = LatLng(restaurante.latitude.toDouble(), restaurante.longitude.toDouble())
                    ),
                    title = restaurante.name
                )
            }


            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(Icons.Default.Call, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Llamar")
            }


            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(Icons.Default.Public, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Sitio Web")
            }
        }
    }
}

