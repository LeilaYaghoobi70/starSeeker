package detail.trivago.presenter.viewComponent

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import app.trivago.presenter.R
import detail.trivago.presenter.contract.CharacterDetailState
import app.trivago.design.R as domainR

@Composable
fun CharacterDetailBody(state: CharacterDetailState) {
    val films = state.characterInfo?.films
    val species = state.characterInfo?.species
    val characterInfo = state.characterInfo

    AnimatedVisibility(
        visible = state.characterInfo != null,
        enter = EnterTransition.None,
        exit = ExitTransition.None,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            TitleView(title = stringResource(id = R.string.character))
            CharacterItem(
                characterName = characterInfo?.characterName ?: "",
                birthYear = characterInfo?.birthYear ?: "",
                height = characterInfo?.height ?: "",
                population = characterInfo?.population ?: "",
            )
            films?.let {
                Spacer(modifier = Modifier.height(height = dimensionResource(id = domainR.dimen.padding_medium)))
                TitleView(title = stringResource(id = R.string.film))
                Spacer(modifier = Modifier.height(height = dimensionResource(id = domainR.dimen.padding_small)))
                FilmsView(films = films)
            }
            species?.let {
                Spacer(modifier = Modifier.height(height = dimensionResource(id = domainR.dimen.padding_medium)))
                TitleView(title = stringResource(id = R.string.species))
                Spacer(modifier = Modifier.height(height = dimensionResource(id = domainR.dimen.padding_small)))
                SpeciesView(species = species)
            }
        }
    }
}
