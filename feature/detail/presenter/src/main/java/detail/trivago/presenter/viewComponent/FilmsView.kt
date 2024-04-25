package detail.trivago.presenter.viewComponent

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import app.trivago.design.theme.HintColor
import app.trivago.presenter.R
import detail.trivago.presenter.model.Film

@Composable
fun FilmsView(
    modifier: Modifier =
        Modifier
            .padding(horizontal = dimensionResource(id = app.trivago.design.R.dimen.padding_medium))
            .background(
                color = HintColor,
                shape = RoundedCornerShape(dimensionResource(id = app.trivago.design.R.dimen.radius_small)),
            ),
    films: List<Film>,
) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(dimensionResource(app.trivago.design.R.dimen.padding_small)),
    ) {
        items(films.size) {
            Column {
                ItemView(
                    title = stringResource(id = R.string.characterName),
                    value = films[it].title,
                )
                Spacer(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .width(dimensionResource(app.trivago.design.R.dimen.padding_small)),
                )
                ItemView(
                    title = stringResource(id = R.string.description),
                    value = films[it].openingCrawl,
                )
            }
        }
    }
}
