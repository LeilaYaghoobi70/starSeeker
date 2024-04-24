package search.trivago.data.model

import com.google.gson.annotations.SerializedName

data class SearchEntity(
    @SerializedName("count")
    val count: Int,
    @SerializedName("results")
    val results: List<CharacterEntity>,
)
