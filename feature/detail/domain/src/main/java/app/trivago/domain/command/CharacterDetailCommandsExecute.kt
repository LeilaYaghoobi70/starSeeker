package app.trivago.domain.command

import app.trivago.domain.model.Charact
import app.trivago.detail.domain.repository.CharacterDetailRepository
import javax.inject.Inject

class CharacterDetailCommandsExecute @Inject constructor(
    private val characterDetailRepository: CharacterDetailRepository,
) {
    suspend fun getCharactersDetails(
        charact: Charact
    ) = CharacterDetailCommands.GetCharactersCharacterDetail(
        charact = charact
    ).execute(characterDetailRepository)
}
