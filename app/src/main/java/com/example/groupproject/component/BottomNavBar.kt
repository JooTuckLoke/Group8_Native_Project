import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navArgument
import com.example.groupproject.data.ItemDatabase
import com.example.groupproject.navigation.NavigationItems
import com.example.groupproject.navigation.Screen
import com.example.groupproject.view.*


@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItems.Home,
        NavigationItems.Category,
        NavigationItems.Wishlist
    )
    BottomNavigation(
        backgroundColor = colorResource(id = com.google.android.material.R.color.design_default_color_primary),
        contentColor = Color.White,
        elevation = 5.dp
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title, Modifier.then(Modifier.size(width = 30.dp, height = 30.dp))) },
                label = { Text(text = item.title) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = false
                    }
                }
            )
        }
    }
}


@Composable
fun BottomBarMain(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItems.Home.route) {
        composable(NavigationItems.Home.route){
            Home(navController = navController, ItemDatabase.itemList)
            }

        composable(NavigationItems.Category.route) {
            Category(navController = navController, ItemDatabase.itemList)
        }
        composable(NavigationItems.Wishlist.route) {
            Wishlist(navController = navController, ItemDatabase.itemList)
        }

        composable(
            "${Screen.Details.route}/{id}/{title}/{location}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) {
            Details(navController, it.arguments?.getInt("id") ?: 0)
        }
    }
}


