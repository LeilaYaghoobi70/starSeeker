package detail.trivago.domain.usecase

import detail.trivago.domain.repository.CharacterDetailRepository
import javax.inject.Inject

class FetchSpeciesUseCase
    @Inject
    constructor(
        private val characterDetailRepository: CharacterDetailRepository,
    ) {
        suspend fun execute(urls: List<String>) =
            characterDetailRepository.fetchSpecies(
                urls = urls,
            )
    }
