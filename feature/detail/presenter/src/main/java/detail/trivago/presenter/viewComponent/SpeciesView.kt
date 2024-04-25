package detail.trivago.presenter.viewComponent

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import app.trivago.design.theme.HintColor
import app.trivago.presenter.R
import detail.trivago.presenter.model.Species
import app.trivago.design.R as designR

@Composable
fun SpeciesView(
    modifier: Modifier =
        Modifier
            .padding(horizontal = dimensionResource(id = designR.dimen.padding_medium))
            .background(
                color = HintColor,
                shape = RoundedCornerShape(dimensionResource(id = designR.dimen.radius_small)),
            ),
    species: List<Species>,
) {
    LazyRow(
        modifier = modifier,
    ) {
        items(species.size) {
            Column {
                ItemView(
                    title = stringResource(id = R.string.name),
                    value = species[it].name,
                )
                ItemView(
                    title = stringResource(id = R.string.language),
                    value = species.get(it).language,
                )
                ItemView(
                    title = stringResource(id = R.string.homeWorld),
                    value = species[it].homeWorld ?: "------",
                )
            }
        }
    }
}
