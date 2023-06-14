package code.sandeep.compose_navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import code.sandeep.compose_navigation.ui.DetailScreen
import code.sandeep.compose_navigation.ui.MainScreen
import code.sandeep.compose_navigation.ui.Screen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(
            route = Screen.MainScreen.route
        ) {
            MainScreen(navController = navController)
        }
        composable(
            route = Screen.DetailScreen.route + "/{name}",
            arguments = listOf(navArgument("name") {
                type = NavType.StringType
                defaultValue = "Sandeep"
                nullable = true
            })
        ) { navBackStackEntry ->
            DetailScreen(name = navBackStackEntry.arguments?.getString("name"))

        }
    }
}