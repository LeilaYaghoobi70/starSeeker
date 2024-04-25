package detail.trivago.domain.usecase

import detail.trivago.domain.repository.CharacterDetailRepository
import javax.inject.Inject

class FetchPlanetUseCase
    @Inject
    constructor(
        private val characterDetailRepository: CharacterDetailRepository,
    ) {
        suspend fun execute(url: String) =
            characterDetailRepository.fetchPlanet(
                planetUrl = url,
            )
    }
