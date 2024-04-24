package app.trivago.starseeker.ui.navigator

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import detail.trivago.presenter.viewComponent.UserDetailScreen
import detail.trivago.presenter.viewmodel.DetailScreenViewModel
import search.trivago.domain.model.Character
import search.trivago.presenter.viewComponent.SearchScreen

@Composable
fun Navigator(navHostController: NavHostController) {
    val actions = remember { Actions(navHostController) }
    NavHost(
        navController = navHostController,
        startDestination = Destinations.SEARCH,
    ) {
        composable(route = Destinations.SEARCH) {
            SearchScreen(
                navigateToDetail = actions.navigateToDetail,
            )
        }
        composable(
            route = "${Destinations.DETAIL}/{${DestinationArgs.CHARACTER}}",
            arguments =
                listOf(
                    navArgument(DestinationArgs.CHARACTER) {
                        type = NavType.StringType
                    },
                ),
        ) {
            val viewModel: DetailScreenViewModel = hiltViewModel()
            UserDetailScreen(
                detailScreenViewModel = viewModel,
            )
        }
    }
}

class Actions(private val navHostController: NavHostController) {
    val navigateToDetail: (character: Character) -> Unit = {
        navHostController.navigate("${Destinations.DETAIL}/$it")
    }

    val navigateBack: () -> Unit = { navHostController.popBackStack() }
}
