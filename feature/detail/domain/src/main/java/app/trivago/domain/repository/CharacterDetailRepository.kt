package app.trivago.detail.domain.repository

import app.trivago.domain.model.Charact
import app.trivago.domain.model.CharacterDetail

interface CharacterDetailRepository {
    suspend fun getCharacterDetail(charact: Charact): CharacterDetail?
}
