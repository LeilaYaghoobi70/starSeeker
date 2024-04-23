package app.trivago.domain.command

import app.trivago.domain.model.Character
import app.trivago.domain.model.CharacterDetail
import app.trivago.domain.processor.CharacterDetailProcessor

abstract class StarSeekerCommand<in T, out M> {

    data class GetCharacters(
        val character: String,
    ) : StarSeekerCommand<CharacterDetailProcessor, List<Character>?>() {
        override suspend fun execute(
            characterDetailProcessor: CharacterDetailProcessor,
        ): List<Character>? =
            characterDetailProcessor.getCharacters(
                character = character
            )
    }

    data class GetCharactersDetails(
        val characterId: String,
    ) : StarSeekerCommand<CharacterDetailProcessor, CharacterDetail>() {
        override suspend fun execute(
            characterDetailProcessor: CharacterDetailProcessor,
        ): CharacterDetail? = characterDetailProcessor.getCharacterDetail(characterId = characterId)

    }

    internal abstract suspend fun execute(t: T): M?
}