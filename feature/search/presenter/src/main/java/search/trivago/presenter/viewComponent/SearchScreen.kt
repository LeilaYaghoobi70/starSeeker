package search.trivago.presenter.viewComponent

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import search.trivago.presenter.contract.SearchScreenActions
import search.trivago.presenter.contract.SearchScreenViewState
import search.trivago.presenter.model.Character
import search.trivago.presenter.viewModel.SearchScreenViewModel

@Composable
fun SearchScreen(
    searchScreenViewModel: SearchScreenViewModel = hiltViewModel(),
    navigateToDetail: (character: Character) -> Unit,
) {
    val viewState by searchScreenViewModel.uiState.collectAsState()
    val actions =
        SearchScreenActions(
            search = searchScreenViewModel::search,
            navigateToDetail = navigateToDetail,
        )

    SearchBody(
        viewState = viewState,
        actions = actions,
    )
}

@Composable
internal fun SearchBody(
    viewState: SearchScreenViewState,
    actions: SearchScreenActions,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        SearchTextField(
            searchTermTyped = actions.search,
        )
        AnimatedVisibility(
            visible = viewState.characters.isNullOrEmpty().not(),
            enter = EnterTransition.None,
            exit = ExitTransition.None,
        ) {
            CharacterBody(
                characters = viewState.characters ?: emptyList(),
                onClickItem = actions.navigateToDetail,
            )
        }
        AnimatedVisibility(
            visible = viewState.showLoading,
            enter = EnterTransition.None,
            exit = ExitTransition.None,
        ) {
            LoadingBody()
        }
    }
}
