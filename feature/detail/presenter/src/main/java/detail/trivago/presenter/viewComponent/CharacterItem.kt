package detail.trivago.presenter.viewComponent

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import app.trivago.design.theme.HintColor
import app.trivago.presenter.R
import app.trivago.design.R as designR

@Composable
fun CharacterItem(
    characterName: String,
    birthYear: String,
    height: String,
    population: String,
) {
    Column(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(dimensionResource(designR.dimen.padding_medium))
                .background(
                    color = HintColor,
                    shape = RoundedCornerShape(dimensionResource(id = designR.dimen.radius_small)),
                )
                .padding(dimensionResource(designR.dimen.padding_medium)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
    ) {
        ItemView(
            title = stringResource(id = R.string.characterName),
            value = characterName,
        )
        ItemView(
            title = stringResource(id = R.string.birthYear),
            value = birthYear,
        )
        ItemView(title = stringResource(id = R.string.height), value = height)
        ItemView(
            title = stringResource(id = R.string.population),
            value = population,
        )
    }
}
