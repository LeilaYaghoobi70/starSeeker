package search.trivago.data.model

import com.google.gson.annotations.SerializedName

data class CharacterEntity(
    @SerializedName("name")
    val name: String,
    @SerializedName("birth_year")
    val birthYear: String,
    @SerializedName("height")
    val height: String,
    @SerializedName("films")
    val films: List<String>,
    @SerializedName("homeworld")
    val homeWorld: String,
    @SerializedName("species")
    val species: List<String>,
    @SerializedName("url")
    val url: String,
)
