package search.trivago.presenter.viewComponent

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import search.trivago.presenter.contract.SearchScreenActions
import search.trivago.presenter.contract.SearchScreenViewState

@Composable
internal fun SearchBody(
    viewState: SearchScreenViewState,
    action: SearchScreenActions,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        SearchTextField(
            searchTermTyped = action.search,
        )
        AnimatedVisibility(
            visible = viewState.characters.isNullOrEmpty().not(),
            enter = EnterTransition.None,
            exit = ExitTransition.None,
        ) {
            CharacterBody(
                characters = viewState.characters ?: emptyList(),
                onClickItem = action.navigateToDetail,
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
