package search.trivago.presenter.viewComponent

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import app.trivago.design.theme.HintColor
import app.trivago.presenter.R
import search.trivago.presenter.model.Character

@Composable
fun CharacterBody(
    characters: List<Character>,
    onClickItem: (Character) -> Unit,
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(characters.size) {
            CharacterItem(
                character = characters[it],
                onClickItem = onClickItem,
            )
        }
    }
}

@Composable
private fun CharacterItem(
    character: Character,
    onClickItem: (Character) -> Unit,
) {
    Row(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(dimensionResource(R.dimen.padding_medium))
                .background(
                    color = HintColor,
                    shape = RoundedCornerShape(dimensionResource(id = R.dimen.radius_small)),
                )
                .padding(dimensionResource(R.dimen.padding_medium))
                .height(dimensionResource(id = R.dimen.item_height))
                .clickable {
                    onClickItem.invoke(character)
                },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(text = character.name)
        Text(text = character.birthYear)
    }
}
