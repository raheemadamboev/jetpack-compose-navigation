package xyz.teamgravity.jetpackcomposenavigation

sealed class Screen(val route: String) {
    object Main : Screen("main_screen")
    object Detail : Screen("detail_screen")

    fun args(vararg args: String) = buildString {
        append(route)
        args.forEach { args ->
            append("/$args")
        }
    }
}
