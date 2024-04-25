package detail.trivago.domain.usecase

import detail.trivago.domain.repository.CharacterDetailRepository
import javax.inject.Inject

class FetchFilmUseCase
    @Inject
    constructor(
        private val characterDetailRepository: CharacterDetailRepository,
    ) {
        suspend fun execute(urls: List<String>) =
            characterDetailRepository.fetchFilms(
                urls = urls,
            )
    }
