package detail.trivago.presenter.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Character(
    val name: String,
    val birthYear: String,
    val height: String,
    val films: List<String>,
    val homeWorld: String,
    val species: List<String>,
    val url: String,
) : Parcelable
