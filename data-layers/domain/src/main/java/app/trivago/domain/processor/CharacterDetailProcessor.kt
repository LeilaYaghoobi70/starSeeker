package app.trivago.domain.processor

import app.trivago.domain.model.Character
import app.trivago.domain.model.CharacterDetail

interface CharacterDetailProcessor {
    suspend fun getCharacters(character: String): List<Character>?
    suspend fun getCharacterDetail(characterId: String): CharacterDetail?
}