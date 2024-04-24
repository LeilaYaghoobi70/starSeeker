package app.trivago.domain.command

import app.trivago.domain.model.Charact
import app.trivago.domain.model.CharacterDetail
import app.trivago.detail.domain.repository.CharacterDetailRepository


sealed class CharacterDetailCommands<in T, out M> {
    data class GetCharactersCharacterDetail(
        val charact: Charact,
    ) : CharacterDetailCommands<CharacterDetailRepository, CharacterDetail>() {
        override suspend fun execute(
            characterDetailRepository: CharacterDetailRepository,
        ): CharacterDetail? = characterDetailRepository.getCharacterDetail(
            charact = charact,
        )

    }

    internal abstract suspend fun execute(t: T): M?
}
