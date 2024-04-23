package app.trivago.remote.processor

import app.trivago.domain.model.Character
import app.trivago.domain.model.CharacterDetail
import app.trivago.domain.processor.CharacterDetailProcessor
import app.trivago.remote.apiService.StarApiService

class CharacterDetailProcessorImp(
   private val starApiService: StarApiService,
) : CharacterDetailProcessor {
    override suspend fun getCharacters(character: String): List<Character>? {
        TODO("Not yet implemented")
    }

    override suspend fun getCharacterDetail(characterId: String): CharacterDetail? {
        TODO("Not yet implemented")
    }
}