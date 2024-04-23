package app.trivago.domain.model

data class CharacterDetail(
    val nameSpecies: String?,
    val languageSpecies: String?,
    val homeWorldSpecies: String?,
    val populationPlanets: String?,
    val files: List<Map<String?, String?>>?,
)