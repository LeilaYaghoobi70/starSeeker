package app.trivago.starseeker.ui.navigator

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import app.trivago.starseeker.mapper.searchToDetail
import detail.trivago.presenter.model.Character
import detail.trivago.presenter.viewComponent.CharacterDetailScreen
import detail.trivago.presenter.viewmodel.DetailScreenViewModel
import search.trivago.presenter.viewComponent.SearchScreen

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun Navigator(navHostController: NavHostController) {
    val actions = remember { Actions(navHostController) }
    NavHost(
        navController = navHostController,
        startDestination = Destinations.SEARCH,
    ) {
        composable(route = Destinations.SEARCH) {
            SearchScreen(
                navigateToDetail = {
                    actions.navigateToDetail(
                        it.searchToDetail(),
                    )
                },
            )
        }
        composable(
            route = Destinations.DETAIL,
        ) {
            val viewModel: DetailScreenViewModel = hiltViewModel()
            val character =
                navHostController.previousBackStackEntry?.savedStateHandle?.get<Character>(
                    DestinationArgs.CHARACTER,
                ) ?: return@composable

            CharacterDetailScreen(
                detailScreenViewModel = viewModel,
                character = character,
            )
        }
    }
}

class Actions(private val navHostController: NavHostController) {
    val navigateToDetail: (character: Character) -> Unit = {
        navHostController.currentBackStackEntry?.savedStateHandle?.apply {
            set(DestinationArgs.CHARACTER, it)
        }
        navHostController.navigate(Destinations.DETAIL)
    }
}
