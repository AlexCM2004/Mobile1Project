package com.example.mobile1project.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mobile1project.ids.IdsView
import com.example.mobile1project.ids.imc.views.IMCView
import com.example.mobile1project.firstpartial.FirstPartialView
import com.example.mobile1project.ids.sum.views.SumAppView
import com.example.mobile1project.ids.fahrenheit.views.FahrenheitView
import com.example.mobile1project.ids.student.viewmodels.StudentViewModel
import com.example.mobile1project.ids.student.views.StudentList
import com.example.mobile1project.secondpartial.SecondPartialView
import com.example.mobile1project.thirdpartial.ThirdPartialView
import restaurantes.models.Restaurante
import restaurantes.views.RestauranteDetailView
import restaurantes.views.RestauranteView
import thirdpartial.estudiante.views.EstudianteView
import thirdpartial.location.LocationListScreen
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

@Composable
fun TabBarNavigationView(navController: NavHostController = rememberNavController()) {
    val items = listOf(
        ScreenNavigation.Ids,
        ScreenNavigation.FirstPartial,
        ScreenNavigation.SecondPartial,
        ScreenNavigation.ThirdPartial
    )

    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                items.forEach { screen ->
                    NavigationBarItem(
                        icon = { Icon(screen.icon, contentDescription = screen.label) },
                        label = { Text(screen.label) },
                        selected = currentRoute == screen.route,
                        onClick = {
                            if (currentRoute != screen.route) {
                                navController.navigate(screen.route) {
                                    popUpTo(navController.graph.startDestinationId) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = ScreenNavigation.Ids.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(ScreenNavigation.Ids.route) { IdsView(navController) }
            composable(ScreenNavigation.FirstPartial.route) { FirstPartialView() }
            composable(ScreenNavigation.SecondPartial.route) { SecondPartialView() }
            composable(ScreenNavigation.ThirdPartial.route) { ThirdPartialView(navController) }
            composable(ScreenNavigation.Imc.route) { IMCView() }
            composable(ScreenNavigation.Sum.route) { SumAppView() }
            composable(ScreenNavigation.Temp.route) { FahrenheitView() }
            composable(ScreenNavigation.Student.route) { StudentList(StudentViewModel()) }
            composable(ScreenNavigation.Locations.route) { LocationListScreen() }
            composable(ScreenNavigation.Estudiantes.route) { EstudianteView() }
            composable(ScreenNavigation.Restaurantes.route) { RestauranteView(navController = navController) }
            composable(
                route = "RestauranteDetailRoute/{name}/{imgName}/{latitude}/{longitude}/{phone}/{webSite}",
                arguments = listOf(
                    navArgument("name") { defaultValue = "" },
                    navArgument("imgName") { defaultValue = "" },
                    navArgument("latitude") { defaultValue = "" },
                    navArgument("longitude") { defaultValue = "" },
                    navArgument("phone") { defaultValue = "" },
                    navArgument("webSite") { defaultValue = "" },
                )
            ) { backStackEntry ->
                val restaurante = Restaurante(
                    name = URLDecoder.decode(backStackEntry.arguments?.getString("name") ?: "", StandardCharsets.UTF_8.toString()),
                    imgName = URLDecoder.decode(backStackEntry.arguments?.getString("imgName") ?: "", StandardCharsets.UTF_8.toString()),
                    schedule = "",
                    phone = URLDecoder.decode(backStackEntry.arguments?.getString("phone") ?: "", StandardCharsets.UTF_8.toString()),
                    rating = 0f,
                    delivery = "",
                    isFavorite = false,
                    fee = "",
                    webSite = URLDecoder.decode(backStackEntry.arguments?.getString("webSite") ?: "", StandardCharsets.UTF_8.toString()),
                    latitude = URLDecoder.decode(backStackEntry.arguments?.getString("latitude") ?: "", StandardCharsets.UTF_8.toString()),
                    longitude = URLDecoder.decode(backStackEntry.arguments?.getString("longitude") ?: "", StandardCharsets.UTF_8.toString())
                )
                RestauranteDetailView(restaurante = restaurante)
            }

        }
    }
}