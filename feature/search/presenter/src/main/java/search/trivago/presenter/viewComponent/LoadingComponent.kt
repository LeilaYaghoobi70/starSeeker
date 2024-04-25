package search.trivago.presenter.viewComponent

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.dimensionResource
import app.trivago.design.theme.LoadingColorFive
import app.trivago.design.theme.LoadingColorFour
import app.trivago.design.theme.LoadingColorOne
import app.trivago.design.theme.LoadingColorSeven
import app.trivago.design.theme.LoadingColorSix
import app.trivago.design.theme.LoadingColorThree
import app.trivago.design.theme.LoadingColorTwo
import app.trivago.design.R as designR

@Composable
fun FaceCaptureLoading() {
    val animationDuration = 500

    val colors =
        mutableListOf(
            LoadingColorOne,
            LoadingColorTwo,
            LoadingColorThree,
            LoadingColorFour,
            LoadingColorFive,
            LoadingColorSix,
            LoadingColorSeven,
        ).apply {
            this.addAll(this.reversed())
        }

    val rotateAnimation by rememberInfiniteTransition(
        label = "FaceCaptureLoading",
    ).animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec =
            infiniteRepeatable(
                animation =
                    tween(
                        durationMillis = animationDuration,
                        easing = LinearEasing,
                    ),
            ),
        label = "AnimateFloatFaceCaptureLoading",
    )

    CircularProgressIndicator(
        modifier =
            Modifier
                .size(size = dimensionResource(id = designR.dimen.loading_size))
                .rotate(rotateAnimation)
                .border(
                    width = dimensionResource(id = designR.dimen.loading_stroke_width),
                    brush = Brush.sweepGradient(colors),
                    shape = CircleShape,
                ),
        color = MaterialTheme.colorScheme.background,
    )
}
