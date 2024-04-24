package detail.trivago.data.repository

import detail.trivago.data.apiService.DetailApiService
import detail.trivago.domain.model.Character
import detail.trivago.domain.model.CharacterDetail
import detail.trivago.domain.repository.CharacterDetailRepository

class CharacterDetailRepositoryImp(
    private val detailApiService: DetailApiService,
) : CharacterDetailRepository {
    override suspend fun getCharacterDetail(character: Character): CharacterDetail? {
        TODO("Not yet implemented")
    }
}
