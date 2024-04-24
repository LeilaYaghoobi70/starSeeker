package detail.trivago.domain.repository

import detail.trivago.domain.model.Character
import detail.trivago.domain.model.CharacterDetail

interface CharacterDetailRepository {
    suspend fun getCharacterDetail(character: Character): CharacterDetail?
}
