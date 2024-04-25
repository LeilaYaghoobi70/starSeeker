package search.trivago.presenter.viewComponent

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import search.trivago.presenter.contract.SearchScreenActions
import search.trivago.presenter.model.Character
import search.trivago.presenter.viewModel.SearchScreenViewModel

@Composable
fun SearchScreen(
    searchScreenViewModel: SearchScreenViewModel = hiltViewModel(),
    navigateToDetail: (character: Character) -> Unit,
) {
    val viewState by searchScreenViewModel.uiState.collectAsState()
    val action =
        SearchScreenActions(
            search = searchScreenViewModel::search,
            navigateToDetail = navigateToDetail,
        )

    SearchBody(
        viewState = viewState,
        action = action,
    )
}
