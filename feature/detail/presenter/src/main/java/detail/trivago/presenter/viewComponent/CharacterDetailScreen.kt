package detail.trivago.presenter.viewComponent

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import detail.trivago.presenter.contract.CharacterDetailAction
import detail.trivago.presenter.model.Character
import detail.trivago.presenter.viewmodel.DetailScreenViewModel

@Composable
fun CharacterDetailScreen(
    detailScreenViewModel: DetailScreenViewModel,
    character: Character,
) {
    val viewState by detailScreenViewModel.uiState.collectAsState()
    val action =
        CharacterDetailAction(
            getDetail = detailScreenViewModel::getCharacterDetail,
        )

    LaunchedEffect(key1 = Unit, block = {
        action.getDetail.invoke(character)
    })

    CharacterDetailBody(
        state = viewState,
    )
}
