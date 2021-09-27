package xyz.teamgravity.jetpackcomposenavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import xyz.teamgravity.jetpackcomposenavigation.screen.Detail
import xyz.teamgravity.jetpackcomposenavigation.screen.Main

@Composable
fun Navigation() {
    val navController = rememberNavController()

    // nav host
    NavHost(navController = navController, startDestination = Screen.Main.route) {
        // create screens
        composable(route = Screen.Main.route) {
            Main(navController = navController)
        }

        composable(
            // /{name} must
            // ?name={name} optional
            route = Screen.Detail.route + "/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "Raheem"
                    nullable = false
                }
            )
        ) { entry ->
            Detail(text = entry.arguments!!.getString("name")!!)
        }
    }
}