package app.trivago.domain.model

data class Charact(
    val name: String,
    val birthYear: String,
    val height: String,
    val films: List<String>,
    val homeWorld: String,
    val species: List<String>,
    val url: String,
)
