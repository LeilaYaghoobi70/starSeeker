package detail.trivago.presenter.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import detail.trivago.domain.model.Character
import detail.trivago.domain.usecase.CharacterDetailUseCase
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewModel
    @Inject
    constructor(
        val characterDetailUseCase: CharacterDetailUseCase,
    ) : ViewModel() {
        suspend fun search(character: Character) {
            // searchCommandExecute.getCharactersDetails(character)
        }
    }
