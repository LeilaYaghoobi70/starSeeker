package detail.trivago.presenter.model

data class CharacterInfo(
    val characterName: String,
    val birthYear: String,
    val height: String,
    val species: List<Specie>,
    val population: String,
    val films: List<Film>,
)
