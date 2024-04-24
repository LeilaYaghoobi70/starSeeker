package search.trivago.presenter.viewComponent

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import app.trivago.design.theme.PlaceHolderColor
import app.trivago.presenter.R
import kotlinx.coroutines.delay

private const val WAITING_TIME: Long = 2000

@Composable
fun SearchTextField(searchTermTyped: (String) -> Unit) {
    val focusRequester = remember { FocusRequester() }
    var searchInputText by remember { mutableStateOf(TextFieldValue("")) }

    TextField(
        value = searchInputText,
        onValueChange = {
            searchInputText = it
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors =
            TextFieldDefaults.colors(
                unfocusedContainerColor = PlaceHolderColor,
                cursorColor = MaterialTheme.colorScheme.primary,
                unfocusedIndicatorColor = MaterialTheme.colorScheme.primary,
                focusedIndicatorColor = MaterialTheme.colorScheme.primary,
            ),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.radius_small)),
        leadingIcon = {
            Image(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = null,
            )
        },
        maxLines = 1,
        modifier =
            Modifier
                .padding(
                    top = dimensionResource(id = R.dimen.padding_medium),
                )
                .focusRequester(focusRequester)
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_medium)),
    )

    LaunchedEffect(key1 = searchInputText, block = {
        // showLoading(searchInputText.text)
        delay(WAITING_TIME)
        searchTermTyped(searchInputText.text)
    })
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun SearchBarPreview() {
    Surface {
        SearchTextField {
        }
    }
}
