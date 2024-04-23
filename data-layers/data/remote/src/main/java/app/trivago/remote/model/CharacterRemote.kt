package app.trivago.remote.model

import com.google.gson.annotations.SerializedName

data class CharacterRemote(
    @SerializedName("name")
    val name: String,
    @SerializedName("birth_year")
    val birth_year: String,
    @SerializedName("height")
    val height: String,
    @SerializedName("films")
    val films: List<String>,
    @SerializedName("homeworld")
    val homeWorld: String,
    @SerializedName("species")
    val species: List<String>,
    @SerializedName("url")
    val url: String
)
