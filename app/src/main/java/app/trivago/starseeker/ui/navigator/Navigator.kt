package app.trivago.starseeker.ui.navigator


import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import app.trivago.presenter.viewComponent.SearchScreen
import app.trivago.presenter.viewComponent.UserDetailScreen
import app.trivago.presenter.viewModel.SearchScreenViewModel
import app.trivago.presenter.viewmodel.DetailScreenViewModel

@Composable
fun Navigator(navHostController: NavHostController) {
    val actions = remember { Actions(navHostController) }
    NavHost(navController = navHostController, startDestination = Destinations.SEARCH) {
        composable(route = Destinations.SEARCH) {
            val viewModel: SearchScreenViewModel = hiltViewModel()
            SearchScreen(
                searchScreenViewModel = viewModel,
              //  navigateToUserDetail = actions.openUserDetailScreen
            )
        }
        composable(
            route = "${Destinations.DETAIL}/{${DestinationArgs.CHARACTER}}",
            arguments = listOf(navArgument(DestinationArgs.CHARACTER) { type = NavType.StringType })
        ) {
            val viewModel: DetailScreenViewModel = hiltViewModel()

            UserDetailScreen(
                detailScreenViewModel = viewModel,
            )
        }
    }
}

class Actions(private val navHostController: NavHostController) {

    val openUserDetailScreen: (character: Character) -> Unit = {
        navHostController.navigate("${Destinations.DETAIL}/$it")
    }

    val navigateBack: () -> Unit = { navHostController.popBackStack() }
}
