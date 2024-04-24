package app.trivago.data.repository

import app.trivago.data.apiService.DetailApiService
import app.trivago.domain.model.CharacterDetail
import app.trivago.detail.domain.repository.CharacterDetailRepository
import app.trivago.domain.model.Charact

class CharacterDetailRepositoryImp(
    private val detailApiService: DetailApiService,
) : CharacterDetailRepository {
    override suspend fun getCharacterDetail(charact: Charact): CharacterDetail? {
        TODO("Not yet implemented")
    }
}
