package detail.trivago.domain.usecase

import detail.trivago.domain.model.Character
import detail.trivago.domain.repository.CharacterDetailRepository
import javax.inject.Inject

class CharacterDetailUseCase
    @Inject
    constructor(
        private val characterDetailRepository: CharacterDetailRepository,
    ) {
        suspend fun execute(character: Character) {
            characterDetailRepository.getCharacterDetail(
                character = character,
            )
        }
    }
