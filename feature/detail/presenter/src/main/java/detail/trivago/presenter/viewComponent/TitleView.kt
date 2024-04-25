package detail.trivago.presenter.viewComponent

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import app.trivago.design.R

@Composable
internal fun TitleView(
    modifier: Modifier =
        Modifier
            .padding(horizontal = dimensionResource(id = R.dimen.padding_medium)),
    title: String,
) {
    Text(
        modifier = modifier,
        text = title,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        fontWeight = FontWeight.Bold,
        fontSize = dimensionResource(id = R.dimen.large).value.sp,
    )
}
