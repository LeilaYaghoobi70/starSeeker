package detail.trivago.presenter.viewComponent

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextOverflow
import app.trivago.design.R

@Composable
internal fun ColumnScope.ItemView(
    title: String,
    value: String,
) {
    Row {
        Text(text = title)
        Spacer(modifier = Modifier.width(width = dimensionResource(id = R.dimen.padding_medium)))
        Text(text = value, maxLines = 1, overflow = TextOverflow.Ellipsis)
    }

    Spacer(modifier = Modifier.height(height = dimensionResource(id = R.dimen.padding_small)))
}
