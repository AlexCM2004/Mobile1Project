package restaurantes.views

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import restaurantes.viewmodels.RestauranteViewModel
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestauranteView(
    viewModel: RestauranteViewModel = viewModel(),
    navController: NavController
) {
    val restaurantes = viewModel.restaurantes.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Lista de restaurantes") })
        }
    ) {
        LazyColumn(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(restaurantes.value) { restaurante ->
                Card(
                    onClick = {
                        val encodedName = URLEncoder.encode(restaurante.name, StandardCharsets.UTF_8.toString())
                        val encodedImgName = URLEncoder.encode(restaurante.imgName, StandardCharsets.UTF_8.toString())
                        val encodedLatitude = URLEncoder.encode(restaurante.latitude, StandardCharsets.UTF_8.toString())
                        val encodedLongitude = URLEncoder.encode(restaurante.longitude, StandardCharsets.UTF_8.toString())
                        val encodedPhone = URLEncoder.encode(restaurante.phone, StandardCharsets.UTF_8.toString())
                        val encodedWebSite = URLEncoder.encode(restaurante.webSite, StandardCharsets.UTF_8.toString())

                        navController.navigate(
                            "RestauranteDetailRoute/$encodedName/$encodedImgName/$encodedLatitude/$encodedLongitude/$encodedPhone/$encodedWebSite"
                        )
                    },
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        val drawableId = getDrawableId(restaurante.imgName.substringBefore(".").lowercase())

                        if (drawableId != 0) {
                            Image(
                                painter = painterResource(id = drawableId),
                                contentDescription = null,
                                modifier = Modifier.size(64.dp),
                                contentScale = ContentScale.Crop
                            )
                        } else {
                            Text("Imagen no encontrada", modifier = Modifier.size(64.dp))
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text(text = "Restaurante: ${restaurante.name}")
                            Text(text = "Calificación: ${restaurante.rating}")
                            Text(text = "Costo de envío: ${restaurante.fee}")
                            Text(text = "Tiempo estimado de entrega: ${restaurante.delivery}")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun getDrawableId(imageName: String): Int {
    val context = LocalContext.current
    return context.resources.getIdentifier(imageName, "drawable", context.packageName)
}
